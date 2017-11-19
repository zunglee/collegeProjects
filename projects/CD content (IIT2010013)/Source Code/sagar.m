imdata=[];
imdata = imread('g.jpg');

imshow(imdata)
[ll,lh,hl,hh] = dwt2(imdata,'haar'); 
q=uint8(ll);
w=uint8(lh);

e=uint8(hl);
r=uint8(hh);
sz=size(hh);
for i=1:sz
    for j=1:sz
        r(i,j)=99;
    end
end
r
X=idwt2(ll,w,e,r,'haar');

b1=uint8(X);


[a,b,c,d] = dwt2(b1,'haar'); 
e=uint8(d);
e
imshow(b1)