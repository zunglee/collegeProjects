;(function($) {
    /* Stop execution if cookies are not enabled */
    var cookieEnabled=(navigator.cookieEnabled)? true : false;
    //if not IE4+ nor NS6+
    if (typeof navigator.cookieEnabled=="undefined" && !cookieEnabled) {
        document.cookie="testcookie";
        cookieEnabled=(document.cookie.indexOf("testcookie")!=-1)? true : false;
    }
    if (!cookieEnabled) {
        console.log('Cookies are disabled. Exiting operation.');
        return false;
    }
    enable_link_select('popup-domination-link');
    
    
    // the following variables detect whether or not to show the popup //
    //
    //  isMobile    => true when the useragent is in the mobiles list
    //  isHidden    => true when the popup is part of an A/B campaign that's been seen already
    //  isRefBlock  => true when the URL of the page has teh query string pdref=1 in it.
    
    var isMobile = false;
    var mobiles = ['2.0 MMP','240x320','400X240','Android','AvantGo','BlackBerry','BlackBerry9530','Blazer','Cellphone','Danger','DoCoMo',
        'Elaine/3.0','EudoraWeb','Googlebot-Mobile','hiptop','IEMobile','iPhone','iPod','KYOCERA/WX310K','LGE VX','LG/U990',
        'LG-TU915 Obigo','MIDP-2.','MMEF20','MOT-V','NetFront','Newt','Nintendo Wii','Nitro','Nokia','Nokia5800','Opera Mini',
        'Palm','PlayStation Portable','portalmmm','Proxinet','ProxiNet','SHARP-TQ-GX10','SHG-i900','Small','SonyEricsson',
        'Symbian OS','SymbianOS','TS21i-10','UP.Browser','UP.Link','webOS','Windows CE','WinWAP','YahooSeeker/M1A1-R2D2', 'iPad'];
    $.each(mobiles,function(index, value) {
        if (navigator.userAgent.toLowerCase().indexOf(value.toLowerCase()) >= 0)
        {
            isMobile = true;
        }
    });
    if (typeof popup_domination.show_mobiles != 'undefined' && popup_domination.show_mobiles == "true") { isMobile = false; }
    if (typeof popup_domination_new_window == 'undefined') { popup_domination_new_window = 'no'; }
    
    var isHidden = (get_cookie('popup_domination_hide_ab'+popup_domination.campaign) == 'Y');
    var isRefBlock = (location.search.indexOf('pdref=1') > -1);

    if (typeof popup_domination == 'undefined') {
        popup_domination = '';
        return false;
    }
    var timer, exit_shown = false;
    
    $(document).ready(function() {
        vidcheck = setTimeout(function() {check_cookie(popup_domination.popupid,popup_domination.mailingid)},1);
        var cururl = window.location;
        if (decodeURIComponent(popup_domination.conversionpage) == cururl) {
            var abcookie = get_cookie("popup_dom_split_show");
            var camp = popup_domination.campaign;
            if (abcookie == 'Y') {
                var popupid = get_cookie("popup_domination_lightbox");
                var data = {
                    action: 'popup_domination_ab_split',
                    stage: 'opt-in',
                    camp : camp,
                    popupid : popupid,
                    optin: '1'
                };
                jQuery.post(popup_domination_admin_ajax, data, function(response) {
                    document.cookie = 'popup_dom_split_show' + '=; expires=Thu, 01-Jan-70 00:00:01 GMT;';
                });
            }
        }
        
        if (popup_domination.show_anim != "inpost") { $(document).find('body').prepend(popup_domination.output); }
        if (popup_domination.impression_count > 1) {
            if (check_impressions()) {
                return false;
            }
        }
        if (!isHidden && !isRefBlock) {
            switch(popup_domination.show_opt) {
                case 'mouseleave':
                    $('html,body').mouseout(window_mouseout);
                    break;
                case 'unload':
                    enable_unload();
                    break;
                case 'linkclick':
                    if (!popup_domination.linkclick) {
                        popup_domination.linkclick = 'popup-domination-link';
                    }
                    enable_link_select(popup_domination.linkclick);
                    break;
                default:
                    if (popup_domination.delay && popup_domination.delay > 0) {
                        timer = setTimeout(show_lightbox,(popup_domination.delay*1000));
                    } else {
                        show_lightbox();
                    }
                break;
            }
        }
        
        if (popup_domination.center && popup_domination.center == 'Y') { init_center(); }
        
        
        $('#popup_domination_lightbox_wrapper #close-button').click(function() {
            if (popup_domination.close_option != 'false') {
                close_box(popup_domination.popupid, false);
                return false;
            }
        });
        $(document).keydown(function(e) {
            if (e.which == 27 && popup_domination.close_option != 'false') {
                close_box(popup_domination.popupid, false);
                return false;
            }
        });        
        
        if (popup_domination.close_option == 'false') {
            $('#popup_domination_lightbox_close').hide();
        } else {
            $('#popup_domination_lightbox_wrapper #popup_domination_lightbox_close').click(function() {
                close_box(popup_domination.popupid, false);
                return false;
            });
        }
        
        var provider = $('#popup_domination_lightbox_wrapper .provider').val();
        
        
        // TODO REVIEW
        if (provider == 'aw') {
            $('#popup_domination_lightbox_wrapper .form div').append('</form>');
        };
        
        //code to allow 'open in new window' functionality - prevents browsers blocking it.
        if ($('#popup_domination_lightbox_wrapper form').attr("target") == 'popdom' || popup_domination_new_window == "yes")
        {
            $('#popup_domination_lightbox_wrapper input[type="submit"]').attr("onclick","window.open('about:blank','popdom')");
        }
        $('#popup_domination_lightbox_wrapper input[type="submit"],#popdom-inline-container input[type=submit]').live('click', function(e) {
            e.preventDefault();
            
            var checked = false;
            var checkArray = new Array();
            $('#popup_domination_lightbox_wrapper :text').each(function() {
                var $this = $(this), val = $this.val();
                if ($this.data('default_value') && val == $this.data('default_value')) {
                    checkArray.push(false);
                }
                if (val == '' && typeof $this.attr('required') != 'undefined' ) {
                    checkArray.push(false);
                } else {
                    if (val == $this.data('default_value')) {
                        checkArray.push(false);
                    } else {
                        checkArray.push(true);
                    }
                }
            });
            if (typeof $('#popup_domination_lightbox_wrapper .email').val() != 'undefined'){
                if ($('#popup_domination_lightbox_wrapper .email').val().indexOf('@') < 1) { checkArray.push(false); }
            }
            else {
                //this is a redirect theme (well, there's no email field)
                $('#popup_domination_lightbox_wrapper form').get(0).setAttribute('method','get'); //oh yes, another little jQuery "quirk" anyway, make it a get not a post
            }
            //console.log(checkArray);
            checked = !($.inArray(false,checkArray) > -1);
            //console.log(checked);
            var email = $('#popup_domination_lightbox_wrapper .email').val();
            if (typeof email=="undefined") {
                register_optin(provider,false);
            } else if (checked) {
                var name = $('#popup_domination_lightbox_wrapper .name').val();
                var custom1 = $('#popup_domination_lightbox_wrapper .custom1_input').val();
                var custom2 = $('#popup_domination_lightbox_wrapper .custom2_input').val();
                var customf2 = $('#popup_domination_lightbox_wrapper .custom_id2').val();
                var customf1 = $('#popup_domination_lightbox_wrapper .custom_id1').val();
                var listid = $('#popup_domination_lightbox_wrapper .listid').val();
                var mailingid = $('#popup_domination_lightbox_wrapper .mailingid').val();
                var mailnotify = $('#popup_domination_lightbox_wrapper .mailnotify').val();
                var master = $('#popup_domination_lightbox_wrapper .master').val();
                var campaignid = $('#popup_domination_lightbox_wrapper .campaignid').val();
                var campname = $('#popup_domination_lightbox_wrapper .campname').val();
                
                $('#popup_domination_lightbox_wrapper input[type="submit"]').attr('disabled', 'disabled');
                $('#popup_domination_lightbox_wrapper .form input').fadeOut();
                $('#popup_domination_lightbox_wrapper .wait').fadeIn();
                var data = '';
                
                //	if (provider != 'form' && provider != 'aw' && provider != 'nm') {
                
                data = {
                    action: 'popup_domination_lightbox_submit',
                    provider: provider,
                    listid: listid,
                    redirect: popup_domination.redirect,
                    mailingid: mailingid,
                    mailnotify: mailnotify,
                    master: master,
                    campaignid: campaignid,
                    campname: campname,
                    name: name,
                    email: email,
                    custom1: custom1,
                    custom2: custom2,
                    customf1: customf1,
                    customf2: customf2
                };
                jQuery.post(popup_domination_admin_ajax, data, function(response) {
                    if (response.length > 4 && response != "formcode") {
                        $('#popup_domination_lightbox_wrapper input[type="submit"]').removeAttr('disabled', 'disabled');
                        $('#popup_domination_lightbox_wrapper .form input').fadeIn();
                        $('#popup_domination_lightbox_wrapper .wait').fadeOut();
                       
                    } else {
                        register_optin(provider,mailingid);
                    }
                }).error(function() { // error submitting to email provider
                    register_optin(provider,false);
                });

            } else{
                $('popup_domination_lightbox_wrapper form').submit(function(e) {
                    e.preventDefault();
                });
                return false;
            }
            return false;
        });
        
        
        
        $('#popup_domination_lightbox_wrapper .sb_facebook').click(function() {
            if ($(this).hasClass('got_user') == true) {
                var email = $('#popup_domination_lightbox_wrapper .fbemail').val();
                var name = $('#popup_domination_lightbox_wrapper .fbname').val();
                var custom1 = $('#popup_domination_lightbox_wrapper .custom1_input').val();
                var custom2 = $('#popup_domination_lightbox_wrapper .custom2_input').val();
                var customf2 = $('#popup_domination_lightbox_wrapper .custom_id2').val();
                var customf1 = $('#popup_domination_lightbox_wrapper .custom_id1').val();
                var listid = $('#popup_domination_lightbox_wrapper .listid').val();
                var mailingid = $('#popup_domination_lightbox_wrapper .mailingid').val();
                var mailnotify = $('#popup_domination_lightbox_wrapper .mailnotify').val();
                var campaignid = $('#popup_domination_lightbox_wrapper .campaignid').val();
                var campname = $('#popup_domination_lightbox_wrapper .campname').val();
                var master = $('#popup_domination_lightbox_wrapper .master').val();
                $('#popup_domination_lightbox_wrapper input[type="submit"]').attr('disabled', 'disabled');
                $('#popup_domination_lightbox_wrapper .form input').fadeOut();
                $('#popup_domination_lightbox_wrapper .wait').fadeIn();
                if (provider != 'form' && provider != 'aw' && provider != 'nm') {
                    var data = {
                        action: 'popup_domination_lightbox_submit',
                        name: name,
                        email: email,
                        custom1: custom1,
                        custom2: custom2,
                        customf1: customf1,
                        customf2: customf2,
                        provider: provider,
                        listid: listid,
                        mailingid: mailingid,
                        mailnotify: mailnotify,
                        master: master,
                        campaignid: campaignid,
                        campname: campname
                    };
                    
                    jQuery.post(popup_domination_admin_ajax, data, function(response) {
                        if (response.length > 4) {
                            $('#popup_domination_lightbox_wrapper input[type="submit"]').removeAttr('disabled', 'disabled');
                            $('#popup_domination_lightbox_wrapper .form input').fadeIn();
                            $('#popup_domination_lightbox_wrapper .wait').fadeOut();
                        } else {
                            close_box(popup_domination.popupid,mailingid);
                            if (check_split_cookie() != true) {
                            var popupid = popup_domination.popupid;
                            var data = {
                                action: 'popup_domination_analytics_add',
                                stage: 'opt-in',
                                popupid: popup_domination.popupid
                            };
                            jQuery.post(popup_domination_admin_ajax, data, function() {
                                redirect(popup_domination.redirect, provider);
                            });
                            } else {
                                redirect(popup_domination.redirect, provider);
                            }
                        }
                    });
                    } else {
                        $('#popup_domination_lightbox_wrapper .email').val(email);
                        $('#popup_domination_lightbox_wrapper .name').val(name);
                        if (check_split_cookie() != true) {
                            var popupid = popup_domination.popupid;
                            var data = {
                                action: 'popup_domination_analytics_add',
                                stage: 'opt-in',
                                popupid: popup_domination.popupid
                            };
                            jQuery.post(popup_domination_admin_ajax, data, function() {
                                $('#popup_domination_lightbox_wrapper form').submit();
                                close_box(popup_domination.popupid,mailingid);
                            });
                            return false;
                        } else {
                            $('#popup_domination_lightbox_wrapper form').submit();
                            close_box(popup_domination.popupid,mailingid);
                        }
                    return false;
                }
                return false;
            }
        });
        
        
        $(function () {
            var ele = $(".lightbox-download-nums");
            var clr = null;
            var number = $(".lightbox-download-nums").text();
            number = parseInt(number);
            var rand = number;
            loop();
            function loop() {
                clearInterval(clr);
                inloop();
                setTimeout(loop, 1000);
            }
            function inloop() {
                ele.html(rand += 1);
                if (!(rand % 50)) {
                    return;
                }
                clr = setTimeout(inloop, 3000);
            }
        });
        
    });
    
    
    function redirect(page, provider) {
        if (page != '' && provider != 'form') {
            if (popup_domination_new_window != "yes") 
            {
                window.location.href = decodeURIComponent(page);
            }
            else window.open(decodeURIComponent(page),"popdom");
        }
    }
    
    //suspect this function is no longer required...
    function social_submit() {
        if ($('#popup_domination_lightbox_wrapper .fbemail').val() != 'none' && $('#popup_domination_lightbox_wrapper .fbemail').val() != 'none') {
            var checked = false;
            $('#popup_domination_lightbox_wrapper :text').each(function() {
                var $this = $(this), val = $this.val();
                if ($this.data('default_value') && val == $this.data('default_value')) {
                    if (checked)
                    $this.val('').focus();
                    checked = false;
                }
                if (val == '') {
                    checked = false;
                } else {
                    if (val == $this.data('default_value')) {
                        checked = false;
                    } else {
                        checked = true;
                    }
                }
            });
            if (checked) {
                var email = $('#popup_domination_lightbox_wrapper .fbemail').val();
                var name = $('#popup_domination_lightbox_wrapper .fbname').val();
                var listid = $('#popup_domination_lightbox_wrapper .listid').val();
                var provider = $('#popup_domination_lightbox_wrapper .provider').val();
                var mailingid = $('#popup_domination_lightbox_wrapper .mailingid').val();
                $('#popup_domination_lightbox_wrapper input[type="submit"]').attr('disabled', 'disabled');
                $('#popup_domination_lightbox_wrapper .form input').fadeOut();
                $('#popup_domination_lightbox_wrapper .wait').fadeIn();
                if (provider != 'form' && provider != 'aw' && provider != 'nm') {
                    var data = {
                        action: 'popup_domination_lightbox_submit',
                        name: name,
                        email: email,
                        provider: provider,
                        listid: listid
                    };
                    jQuery.post(popup_domination_admin_ajax, data, function(response) {
                        if (response.length > 4) {
                            $('#popup_domination_lightbox_wrapper input[type="submit"]').removeAttr('disabled', 'disabled');
                            $('#popup_domination_lightbox_wrapper .form input').fadeIn();
                            $('#popup_domination_lightbox_wrapper .wait').fadeOut();
                        } else {
                            close_box(popup_domination.popupid,mailingid);
                            if (check_split_cookie() != true) {
                                var popupid = popup_domination.popupid;
                                var data = {
                                    action: 'popup_domination_analytics_add',
                                    stage: 'opt-in',
                                    popupid: popup_domination.popupid
                                };
                                jQuery.post(popup_domination_admin_ajax, data, function() {
                                    redirect(popup_domination.redirect, provider);
                                });
                            } else {
                                redirect(popup_domination.redirect, provider);
                            }
                        }
                    });
                } else {
                    if (check_split_cookie() != true) {
                        var popupid = popup_domination.popupid;
                        var data = {
                            action: 'popup_domination_analytics_add',
                            stage: 'opt-in',
                            popupid: popup_domination.popupid
                        };
                        jQuery.post(popup_domination_admin_ajax, data, function() {
                            $('#popup_domination_lightbox_wrapper form').submit();
                            close_box(popup_domination.popupid,mailingid);
                        });
                        return false;
                    } else {
                        $('#popup_domination_lightbox_wrapper form').submit();
                        close_box(popup_domination.popupid,mailingid);
                    }
                    return false;
                }
            }
            return false;
        }
    }
    
    function register_view() {
        var data = '';
        if (check_split_cookie() != true) {
            data = {
                action: 'popup_domination_analytics_add',
                stage: 'show',
                popupid: popup_domination.popupid
            };
        } else {
            var date = new Date();
            date.setTime(date.getTime() + (86400*1000));
            set_cookie('popup_dom_split_show','Y', date);
            set_cookie('popup_domination_lightbox',popup_domination.popupid,date);
            data = {
                action: 'popup_domination_ab_split',
                stage: 'show',
                popupid: popup_domination.popupid,
                camp : popup_domination.campaign
            };
        }
        jQuery.post(popup_domination_admin_ajax, data);
    }
    
    function register_optin(prov,mailingid) {
        close_box(popup_domination.popupid, mailingid);
        var data = '';
        if (check_split_cookie() != true) {
            data = {
                action: 'popup_domination_analytics_add',
                stage: 'opt-in',
                popupid: popup_domination.popupid
            };
        } else {
            data = {
                action: 'popup_domination_ab_split',
                stage: 'opt-in',
                popupid: popup_domination.popupid,
                camp : popup_domination.campaign
            };
        }
        
        //submit depending on provider
        if (prov == 'form' || prov == 'aw' || typeof prov == "undefined") {
            jQuery.post(popup_domination_admin_ajax, data, function() {
                $('#popup_domination_lightbox_wrapper form').submit();
            });
        } else {
            jQuery.post(popup_domination_admin_ajax, data, function() {
                redirect(popup_domination.redirect, prov);
            });
        }
    }
    
    function enable_unload() {
        window.onbeforeunload = function(e) {
            if (exit_shown === false) {
                e = e || window.event;
                exit_shown = true;
                setTimeout(show_lightbox,1000);
                if (e) { e.returnValue = popup_domination.unload_msg; }
                return popup_domination.unload_msg;
            }
        };
    }

    function enable_link_select(classname) {
        $('.'+classname).click(function(e) {
            e.preventDefault();
            show_lightbox(true);
        }).css('cursor','pointer');
    }

    function window_mouseout(e) {
        var scrollTop = jQuery(window).scrollTop()+5;
        var scrollBottom = jQuery(window).scrollTop() + jQuery(window).height()-5;
        var scrollLeft = jQuery(window).scrollLeft()+5;
        var scrollRight = scrollLeft + jQuery(window).width()-5;
        var mX = e.pageX, mY = e.pageY, el = $(window).find('html');
        
        if ((mX <= scrollLeft) || (mY <= scrollTop) || (mY>= scrollBottom)) {
            show_lightbox();
        }
    }
    
    function show_lightbox(linkclick) {
        if (!isMobile && !isHidden && !isRefBlock && popup_domination.show_anim != "inpost")
        {
            var provider = '';
            $(document).unbind('focus',show_lightbox);
            $('html,body').unbind('mouseout',window_mouseout);
            if (!check_cookie(popup_domination.popupid, popup_domination.mailingid) || linkclick) {
                max_zindex();
                show_animation();
                if (popup_domination.center && popup_domination.center == 'Y') {
                    center_it();
                    }
                register_view();
            }
        }
        if (popup_domination.show_anim == "inpost")
        {
            if (!check_cookie(popup_domination.popupid,popup_domination.mailingid))
            {
                register_view();
            }
            else 
            {
                hide_box();
            }
        }
        provider = $('#popup_domination_lightbox_wrapper .provider').val();
        if (popup_domination_new_window == 'yes') { var new_window_target= "popdom"; }
        else { var new_window_target = ''; }
        $('#popup_domination_lightbox_wrapper .wait').remove(); // set up all forms to use same wait gif placement, after submit button
        $('#popup_domination_lightbox_wrapper input[type=submit]').after('<div class="wait" style="display:none;"><img src="//'+document.domain+'/wp-content/plugins/popup-domination/css/images/wait.gif" /></div>');
                
        if (provider == 'aw') {
            var html = $('#popup_domination_lightbox_wrapper .form div').html();
            if ($('#popup_domination_lightbox_wrapper .form form').html() == null) {
                $('#popup_domination_lightbox_wrapper .form div').html('<form method="post" action="http://www.aweber.com/scripts/addlead.pl" target="'+new_window_target+'">'+html+'</form>')
            } else {
                $('#popup_domination_lightbox_wrapper .form form').remove();
                $('#popup_domination_lightbox_wrapper .form div').html('<form method="post" action="http://www.aweber.com/scripts/addlead.pl" target="'+new_window_target+'">'+html+'</form>')
            }
        }
        
        // IE placeholder workaround
        if ($.browser.msie)
        {
            console.log('this is IE');
            window.setTimeout( function() {
                $('#popup_domination_lightbox_wrapper .name , #popup_domination_lightbox_wrapper .email').each(function() {
                    $(this).val($(this).attr("placeholder"));
                    $(this).focus(function(e) {
                        if ($(this).val() == $(this).attr("placeholder") ) 
                        {
                            $(this).val('');
                            $(this).removeAttr('style');
                            e.preventDefault();
                        }
                    }).blur(function(e) {
                        if ($(this).val() == '') 
                        {
                            $(this).val($(this).attr("placeholder") );
                            $(this).css('color','grey');
                            e.preventDefault();
                        }
                    }).focusout(function(e) {
                        if ($(this).val() == '') 
                        {
                            $(this).val($(this).attr("placeholder") );
                            $(this).css('color','grey');
                            e.preventDefault();
                        }
                    });
                });
            } , 100);
        }
        return false;
    };
    
    /* decides how lightbox is to show */
    function show_animation() {
        $('#popup_domination_lightbox_wrapper >.lightbox-main').css("opacity",0);
        $('#popup_domination_lightbox_wrapper ').show();
        if (popup_domination.show_anim == 'fade') {
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({opacity:1},500,center_it);
        } else if (popup_domination.show_anim == 'slide') {
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({top: 0 - $('#popup_domination_lightbox_wrapper >.lightbox-main').outerHeight(false)},0);
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({
                top: ($(window).height() - $('.popup-dom-lightbox-wrapper .lightbox-main').outerHeight(false))/2,
                opacity:1
            },
            1500,
            center_it);
        } else if (popup_domination.show_anim == 'slideUp') {
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({top: $(window).height() + $('#popup_domination_lightbox_wrapper >.lightbox-main').outerHeight(false)},0);
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({
                top: ($(window).height() - $('.popup-dom-lightbox-wrapper .lightbox-main').outerHeight(false))/2,
                opacity:1
            },
            1500,
            center_it);
        } else if (popup_domination.show_anim == 'slideLeft') { /* Slide TO the left, FROM the right! */
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({left: $(window).width() + $('#popup_domination_lightbox_wrapper >.lightbox-main').outerWidth(false)},0);
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({
                left: ($(window).width() - $('.popup-dom-lightbox-wrapper .lightbox-main').outerWidth(false))/2,
                opacity:1
            },
            1500,
            center_it);
        } else if (popup_domination.show_anim == 'slideRight') {
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({left: 0 - $('#popup_domination_lightbox_wrapper >.lightbox-main').outerWidth(false)},0);
            $('#popup_domination_lightbox_wrapper >.lightbox-main').animate({
                left: ($(window).width() - $('.popup-dom-lightbox-wrapper .lightbox-main').outerWidth(false))/2,
                opacity:1
            },
            1500,
            center_it);
        } 
        else {
            $('#popup_domination_lightbox_wrapper >.lightbox-main').css("opacity",1);
        }
    }
    
    function center_it() {
        transform = 1;
        if ($(window).width() <= $('.popup-dom-lightbox-wrapper .lightbox-main').outerWidth() ) {
            transform = $(window).width() / $('.popup-dom-lightbox-wrapper .lightbox-main').outerWidth(false);
        }
        if ( $(window).height() <= $('.popup-dom-lightbox-wrapper .lightbox-main').outerHeight() ) {
            transform = ($(window).height() / $('.popup-dom-lightbox-wrapper .lightbox-main').outerHeight(false) < transform) ? $(window).height() / $('.popup-dom-lightbox-wrapper .lightbox-main').outerHeight(false) : transform;
        }
        var styles = {
            position:'fixed',
            left: ($(window).width() - $('.popup-dom-lightbox-wrapper .lightbox-main').outerWidth(false))/2,
            top: ($(window).height() - $('.popup-dom-lightbox-wrapper .lightbox-main').outerHeight(false))/2 + 10,
            transform: "scale("+transform+")"
        };
        $('.popup-dom-lightbox-wrapper .lightbox-main').css(styles);
    };
    
    function init_center() {
        center_it();
        $(window).resize(center_it);
    };

    function max_zindex() {
        var maxz = 0;
        $('body *').each(function() {
            var cur = parseInt($(this).css('z-index'));
            maxz = cur > maxz ? cur : maxz;
        });
        $('#popup_domination_lightbox_wrapper ').css('z-index',maxz+10);
    };
    
    function hide_box() {
        $('#popup_domination_lightbox_wrapper ').hide();
        $('#popdom-inline-container').hide(); //hides in-line forms
    }
    
    //closes the popup, if mailingid is set sets cookie for mailing list too
    function close_box(id, mailingid) {
        var elem = $('#popup_domination_lightbox_wrapper , #popdom-inline-container');
        clearTimeout(timer);
        elem.fadeOut('fast');
        if (popup_domination.cookie_time && popup_domination.cookie_time > 0) {
            var date = new Date();
            date.setTime(date.getTime() + (popup_domination.cookie_time*86400*1000));
        }
        else {
            var date = new Date();
            date.setTime(date.getTime() + (1*86400*1000));
        }
        if (id == '0') {
            id = 'zero';
        }else if (id == '1') {
            id = 'one';
        }else if (id == '3') {
            id = 'three';
        }else if (id == '4') {
            id = 'four';
        }
        set_cookie('popup_domination_hide_lightbox'+id,'Y',date);
        stop_video();
        if (check_split_cookie()) {
            set_cookie('popup_domination_hide_ab'+popup_domination.campaign,'Y',date);
        }
        if (mailingid != false) {
        //this means we're setting the cookie for the mailing list - someone opted in!
            date = new Date();
            date.setFullYear(date.getFullYear() + 100); // 100 years ought to do it
            set_cookie('popup_domination_hide_mailing'+mailingid,'Y',date);
        }
    };
    
    function stop_video() {
        //Required for some plugins such as Vimeo
        $('#popup_domination_lightbox_wrapper .lightbox-video').remove();
    };

    function set_cookie(name,value,date) {
        window.document.cookie = [name+'='+escape(value),'expires='+date.toUTCString(),'path='+popup_domination.cookie_path].join('; ');
    };

    function check_cookie(id,mailingid) {
        if (id == '0') {
            id = 'zero';
        }else if (id == '1') {
            id = 'one';
        }else if (id == '3') {
            id = 'three';
        }else if (id == '4') {
            id = 'four';
        }
        if (get_cookie('popup_domination_hide_lightbox'+id) == 'Y' || get_cookie('popup_domination_hide_mailing'+mailingid) == 'Y')
        {
            if (get_cookie('popup_domination_hide_lightbox'+id) == 'Y') console.log("Already seen this popup within the period defined in it's setting.");
            if (get_cookie('popup_domination_hide_mailing'+mailingid) == 'Y') console.log("Already opted in to the mailing list attached to this popup.");
            stop_video();
            return true;
        }
        return false;
    };

    function check_split_cookie() {
        return popup_domination.splitcookie;
    }

    function check_impressions() {
        var ic = 1, date = new Date();
        if (ic = get_cookie('popup_domination_icount')) {
            ic = parseInt(ic);
            ic++;
            if (ic == popup_domination.impression_count) {
                date.setTime(date.getTime());
                set_cookie('popup_domination_icount',popup_domination.impression_count,date);
                return false;
            }
        } else {
            ic = 1;
        }
        date.setTime(date.getTime() + (7200*1000));
        set_cookie('popup_domination_icount',ic,date);
        return true;
    };
    
    function get_cookie(cname) {
        var cookie = window.document.cookie;
        if (cookie.length > 0) {
            var c_start = cookie.indexOf(cname+'=');
            if (c_start !== -1) {
                c_start = c_start + cname.length+1;
                var c_end = cookie.indexOf(';',c_start);
                if (c_end === -1) { c_end = cookie.length; }
                return unescape(cookie.substring(c_start,c_end));
            }
        }
        return false;
    };
    
})(jQuery);