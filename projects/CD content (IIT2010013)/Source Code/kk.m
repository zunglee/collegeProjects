function [] = intoframe(inpath)
   inpath=('h.mpg')
   myVid= mmreader(inpath);
   numFrames= myVid.NumberOfFrames;
   i= 1;
   while i<= numFrames
   currentFrame= read(myVid,i); 
   combinedString=strcat(int2str(i-1),'.jpg');
   imwrite(currentFrame,combinedString);
   i=i+1;
   end
   imdata = imread('g.jpg')
   end