% The current extension mode is zero-padding (see dwtmode).

% Load original image. 
X=[];
X = imread('g.jpg');
% Perform single-level decomposition 
% of X using db4. 
[cA1,cH1,cV1,cD1] = dwt2(X,'db4');
sX = size(X);
% Invert directly decomposition of X 
% using coefficients at level 1. 
A0 = idwt2(cA1,cH1,cV1,cD1,'db4',sX);

imshow(A0)
