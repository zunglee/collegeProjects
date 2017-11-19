workingDir = 'C:\Users\Satan\Documents\MATLAB';
mkdir('C:\Users\Satan\Documents\MATLAB\Images');
shuttleVideo = VideoReader('c.mpg');
for ii = 1:shuttleVideo.NumberOfFrames
    img = read(shuttleVideo,ii);

    % Write out to a JPEG file (img1.jpg, img2.jpg, etc.)
    imwrite(img,fullfile(workingDir,'images',sprintf('img%d.jpg',ii)));
end
imageNames = dir(fullfile(workingDir,'images','*.jpg'));
imageNames = {imageNames.name}';
imageStrings = regexp([imageNames{:}],'(\d*)','match');
imageNumbers = str2double(imageStrings);
[~,sortedIndices] = sort(imageNumbers);
sortedImageNames = imageNames(sortedIndices);
outputVideo = VideoWriter(fullfile(workingDir,'shuttle_out.mpg'));
outputVideo.FrameRate = shuttleVideo.FrameRate;
open(outputVideo);
for ii = 1:length(sortedImageNames)
    img = imread(fullfile(workingDir,'images',sortedImageNames{ii}));

    writeVideo(outputVideo,img);
end
close(outputVideo);
implay('shuttle_out.avi');