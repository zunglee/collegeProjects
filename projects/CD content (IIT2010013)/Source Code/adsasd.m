imdata=[];
imdata = imread('d.jpg');

[ll,lh,hl,hh] = dwt2(imdata,'haar'); 
I = mat2gray(ll);
J = mat2gray(lh);
K = mat2gray(hl);
L = mat2gray(hh);
%%imshow(I)
%%imshow(J)
%%imshow(K)
imshow(L)
