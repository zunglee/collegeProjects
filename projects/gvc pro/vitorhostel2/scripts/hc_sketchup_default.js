function addEvent(a,c,b){if(a.addEventListener){a.addEventListener(c,b,false);return true}else{if(a.attachEvent){return a.attachEvent("on"+c,b)}else{return false}}}function getElementById(e,c){if(!c){return document.getElementById(e)}if(typeof(c)=="string"){var a=document.getElementById(c)}else{var a=c}if(a.id==e){return a}var d=a.firstChild;while(d){if(d.id==e){return d}else{var b=getElementById(e,d);if(b){return b}}d=d.nextSibling}return undefined}function getElementAttribute(c,a){var f=c.outerHTML.substring(1,c.outerHTML.length-1);var d=f.split(" ");for(var b=0;b<d.length;b++){var e=d[b].split("=");if(e[0]==a){return e[1]}}}function isElementLoaded(a){if(a.offsetWidth>0&&a.offsetHeight>0){return true}else{if(a.width>0&&a.height>0){return true}else{return false}}}function swapImage(b,c){var a=c.substring(c.length-3,c.length);if(((a=="png")||(a=="PNG"))&&(typeof(swapPNG)!="undefined")){swapPNG(b,c)}else{b.src=c}}function getImageSrc(a){if(a.src){return a.src}else{return a.filters(0).src}}function getWindowWidth(){if(document.body.offsetWidth){return document.body.offsetWidth}else{return window.innerWidth}}function getWindowHeight(){if(document.body.offsetHeight){return document.body.offsetHeight}else{return window.innerHeight}}function setStatus(a){window.status=a}function clearStatus(){window.status=""}function setWindowLocation(a){window.top.location.href=a}function getWindowLocation(){return window.top.location.href}function getBaseLocation(b){var a=b.split("?");return a[0]}function openDialogBox(g,d,a){var f=(screen.width-d)/2;var e=(screen.height-a)/2;var c="resizeable=no, status=no, toolbar=no, menubar=no, location=no, scrollbars=no, directories=no, dialog=yes";var b=window.open(g,"_blank","width="+d+", height="+a+", top="+e+", left="+f+", "+c);if(window.focus){b.focus()}return b}function getCSSStyle(a){for(i=0;i<document.styleSheets.length;i++){if(document.styleSheets[i].rules){for(j=0;j<document.styleSheets[i].rules.length;j++){if(document.styleSheets[i].rules[j].selectorText==a){return document.styleSheets[i].rules[j].style}}}else{for(j=0;j<document.styleSheets[i].cssRules.length;j++){if(document.styleSheets[i].cssRules[j].selectorText==a){return document.styleSheets[i].cssRules[j].style}}}}}var agt=navigator.userAgent.toLowerCase();var appVer=navigator.appVersion.toLowerCase();var isMinor=parseFloat(appVer);var isMajor=parseInt(isMinor);var iePos=appVer.indexOf("msie");if(iePos!=-1){isMinor=parseFloat(appVer.substring(iePos+5,appVer.indexOf(";",iePos)));isMajor=parseInt(isMinor)}var isKonq=false;var kqPos=agt.indexOf("konqueror");if(kqPos!=-1){isKonq=true;isMinor=parseFloat(agt.substring(kqPos+10,agt.indexOf(";",kqPos)));isMajor=parseInt(isMinor)}var isOpera=(agt.indexOf("opera")!=-1);var isKhtml=(isSafari||isKonq);var isIe=((iePos!=-1)&&(!isOpera)&&(!isKhtml));var isIe6up=(isIe&&isMinor>=6);var isGecko=((!isKhtml)&&(navigator.product)&&(navigator.product.toLowerCase()=="gecko"))?true:false;var isSafari=((agt.indexOf("safari")!=-1)&&(agt.indexOf("mac")!=-1))?true:false;function createIEControl(c,e){var b=document.createElement("object");b.style.width=c.style.width;b.style.height=c.style.height;for(var d in e){b.setAttribute(d,e[d])}if(document.readyState=="complete"){if(c.parentNode){c.parentNode.replaceChild(b,c)}}else{var a=c;document.attachEvent("onreadystatechange",function(){if(document.readyState=="complete"){if(a.parentNode){a.parentNode.replaceChild(b,a)}}})}return b}function createMozillaControl(a,c){if(isSafari){return createSafariControl(a,c)}var d=document.createElement("embed");d.style.width=a.style.width;d.style.height=a.style.height;for(var b in c){d.setAttribute(b,c[b])}self.interval=window.setInterval(function(){if(isElementLoaded(a)){window.clearInterval(self.interval);if(a.parentNode){a.parentNode.replaceChild(d,a)}}},100);return d}function createSafariControl(a,d){var c="<embed";for(var b in d){c+=" "+b+'="'+d[b]+'"'}c+=">";a.innerHTML=c;return document[d.name]}var isWin=((agt.indexOf("win")!=-1)||(agt.indexOf("16bit")!=-1));var isMac=(agt.indexOf("mac")!=-1);if(!isWin&&!isMac){alert("Sorry - Hypercosm is only supported on Windows and the Macintosh");window.top.location="http://www.hypercosm.com/download/player/platform_error.html"}else{if(isIe6up){document.writeln('<script language="VBScript">');document.writeln("On Error Resume Next");document.writeln('Set theObject = CreateObject("HypercosmActivex.HyperX.1")');document.writeln("If IsObject(theObject) Then");document.writeln("hasHypercosm = true");document.writeln("Else");document.writeln("hasHypercosm = false");document.writeln("End If");document.writeln("<\/script>");if(!hasHypercosm){var button=confirm("The Hypercosm Player is needed to view this page.\nWould like to be redirected to the download page?");if(button==true){window.top.location="http://www.hypercosm.com/download/player/index.html"}}}else{if(isGecko||isSafari){hasHypercosm=false;for(i=0;i<navigator.plugins.length;i++){if(navigator.plugins[i].name.substring(0,9)=="Hypercosm"){hasHypercosm=true}}if(!hasHypercosm){var button=confirm("The Hypercosm 3D Player is needed to view this page.\nWould like to be redirected to the  Player's download page?");if(button==true){window.top.location="http://www.hypercosm.com/download/player/index.html"}}}else{window.top.location="http://www.hypercosm.com/download/player/browser_error.html"}}}function component(a,b){if(!a){return this}if(typeof(a)=="string"){if(b){if(b.element){this.element=getElementById(a,b.element)}else{this.element=getElementById(a,b)}}else{this.element=document.getElementById(a)}}else{this.element=a}if(b&&b.addComponent){b.addComponent(this)}this.visible=(this.element!=undefined)&&(this.element.style.display!="none");return this}component.prototype.getTop=function(){var a=this;while(a.parent){a=a.parent}return a};component.prototype.getWidth=function(){if(this.element){if(this.element.offsetWidth!=0){return this.element.offsetWidth}else{if(this.element.width){return this.element.width}else{return this.element.getAttribute("width")}}}else{return 0}};component.prototype.getHeight=function(){if(this.element){if(this.element.offsetHeight!=0){return this.element.offsetHeight}else{if(this.element.height){return this.element.height}else{return this.element.getAttribute("height")}}}else{return 0}};component.prototype.getLeft=function(){var b=0;var a=this.element;if(a.offsetParent){do{b+=a.offsetLeft}while(a=a.offsetParent);return b}};component.prototype.getTop=function(){var b=0;var a=this.element;if(a.offsetParent){do{b+=a.offsetTop}while(a=a.offsetParent);return b}};component.prototype.setElement=function(a){if(this.element.parentNode){this.element.parentNode.replaceChild(a,this.element)}this.element=a};component.prototype.setVisible=function(a){this.visible=a;if(this.element){if(a){this.element.style.display="block"}else{this.element.style.display="none"}}};component.prototype.isVisible=function(){return this.visible&&(!this.parent||!this.parent.isVisible||this.parent.isVisible())};component.prototype.toggleVisible=function(){this.setVisible(!this.isVisible())};function HCApplet(c,b,e,a,d){if(!c){return this}if(a==undefined){a=""}if(d==undefined){d=null}component.call(this,c,d);this.appletSrc=b;this.resources=e;this.commandLine=a;this.plugIn=null;this.index=HCApplet.applets.length;this.id="HCApplet"+this.index;this.commandLine="-id "+this.id+"; "+a;HCApplet.appletIndices[this.id]=HCApplet.applets.length;HCApplet.applets[HCApplet.applets.length]=this;HCApplet.setCurrentApplet(this);this.activate();return this}HCApplet.prototype=new component();HCApplet.prototype.activate=function(){function a(e){var c="";if(e){for(var d=0;d<e.length;d++){c+="'"+e[d]+"'";if(d<e.length){c+="; "}}}return c}if(navigator.appName=="Microsoft Internet Explorer"){var b=new Array();b.id=this.id;b.classid="clsid:34B8892A-9303-4893-9E12-1CEE6C3BF95D";b.AppletSrc=this.appletSrc;b.CommandLine=this.commandLine;b.Resources=a(this.resources);this.plugIn=createIEControl(this.element,b)}else{var b=new Array();b.name=this.id;b.type="application/x-hypercosm";b.width=this.element.style.width;b.height=this.element.style.height;b.appletsrc=this.appletSrc;b.commandline=this.commandLine;b.resources=a(this.resources);b.browser=navigator.userAgent;this.plugIn=createMozillaControl(this.element,b)}};HCApplet.prototype.onActivate=function(){if(this.onload){this.onload()}};HCApplet.prototype.isActivated=function(){return(this.plugIn!=null)};HCApplet.prototype.call=function(script){if(script){eval(script)}};HCApplet.getAppletById=function(a){return this.getAppletByIndex(HCApplet.appletIndices[a])};HCApplet.getAppletByIndex=function(a){return HCApplet.applets[a]};HCApplet.setCurrentApplet=function(a){HCApplet.currentApplet=a};HCApplet.getCurrentApplet=function(){return HCApplet.currentApplet};HCApplet.applets=new Array();HCApplet.appletIndices=new Array();function getTransparencyResources(a){return["transparent0.png, "+a+"/transparency/transparent0.png","transparent10.png, "+a+"/transparency/transparent10.png","transparent20.png, "+a+"/transparency/transparent20.png","transparent30.png, "+a+"/transparency/transparent30.png","transparent40.png, "+a+"/transparency/transparent40.png","transparent50.png, "+a+"/transparency/transparent50.png","transparent60.png, "+a+"/transparency/transparent60.png","transparent70.png, "+a+"/transparency/transparent70.png","transparent80.png, "+a+"/transparency/transparent80.png","transparent90.png, "+a+"/transparency/transparent90.png","transparent100.png, "+a+"/transparency/transparent100.png"]}function getSketchUpIconResources(a){return["about_icon.gif, "+a+"/textures/about_icon.gif","back_arrow_icon.gif, "+a+"/textures/back_arrow_icon.gif","blue_dial_icon.gif, "+a+"/textures/blue_dial_icon.gif","camera_icon.gif, "+a+"/textures/camera_icon.gif","cartoon_icon.gif, "+a+"/textures/cartoon_icon.gif","color_wheel_icon.gif, "+a+"/textures/color_wheel_icon.gif","dial_arrow.gif, "+a+"/textures/dial_arrow.gif","dial_icon.gif, "+a+"/textures/dial_icon.gif","dial_labels.gif, "+a+"/textures/dial_labels.gif","dock_texture.png, "+a+"/textures/dock_texture.png","edges_icon.gif, "+a+"/textures/edges_icon.gif","flat_icon.gif, "+a+"/textures/flat_icon.gif","gauge_icon.gif, "+a+"/textures/gauge_icon.gif","graphics_icon.gif, "+a+"/textures/graphics_icon.gif","green_dial_icon.gif, "+a+"/textures/green_dial_icon.gif","help_icon.gif, "+a+"/textures/help_icon.gif","hide_icon.gif, "+a+"/textures/hide_icon.gif","lighting_icon.gif, "+a+"/textures/lighting_icon.gif","mouse_icon.gif, "+a+"/textures/mouse_icon.gif","object_icon.gif, "+a+"/textures/object_icon.gif","one_button_icon.gif, "+a+"/textures/one_button_icon.gif","outline_icon.gif, "+a+"/textures/outline_icon.gif","pan_icon.gif, "+a+"/textures/pan_icon.gif","red_dial_icon.gif, "+a+"/textures/red_dial_icon.gif","render_modes_icon.gif, "+a+"/textures/render_modes_icon.gif","rotate_icon.gif, "+a+"/textures/rotate_icon.gif","scene_icon.gif, "+a+"/textures/scene_icon.gif","shadow_icon.gif, "+a+"/textures/shadow_icon.gif","smooth_icon.gif, "+a+"/textures/smooth_icon.gif","spin_icon.gif, "+a+"/textures/spin_icon.gif","two_button_icon.gif, "+a+"/textures/two_button_icon.gif","upright_icon.gif, "+a+"/textures/upright_icon.gif","two_button_icon.gif, "+a+"/textures/two_button_icon.gif","wireframe_icon.gif, "+a+"/textures/wireframe_icon.gif","x_ray_icon.gif, "+a+"/textures/x_ray_icon.gif","monochrome_icon.gif, "+a+"/textures/monochrome_icon.gif","monochrome_hidden_line_icon.gif, "+a+"/textures/monochrome_hidden_line_icon.gif","monochrome_edges_icon.gif, "+a+"/textures/monochrome_edges_icon.gif","zoom_icon.gif, "+a+"/textures/zoom_icon.gif"]}function getSketchUpSoundResources(a){return["deselect.wav, "+a+"/sounds/deselect.wav","hide.wav, "+a+"/sounds/hide.wav","select.wav, "+a+"/sounds/select.wav","show.wav, "+a+"/sounds/show.wav"]}function getSketchUpDefaultResources(a){return getTransparencyResources(a).concat(getSketchUpIconResources(a).concat(getSketchUpSoundResources(a)))};