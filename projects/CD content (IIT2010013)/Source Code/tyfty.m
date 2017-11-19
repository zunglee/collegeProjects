imdata=[];
imdata = imread('g.jpg');

[ll,lh,hl,hh] = dwt2(imdata,'haar'); 

I = mat2gray(ll);
J = mat2gray(lh);
K = mat2gray(hl);
L = mat2gray(hh);
hh
%%imshow(I)
%%imshow(J)
%%imshow(K)
%%imshow(L)
X=idwt2(I,J,K,L,'haar');
imshow(X)