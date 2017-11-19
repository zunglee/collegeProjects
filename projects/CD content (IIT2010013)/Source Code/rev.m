load mri
for i=1:500
    M(uint8(i)) = im2frame(uint8(i),map);
end
movie(M)