hmfr = video.MultimediaFileReader;
 hvp = video.VideoPlayer;
 while ~isDone(hmfr)
 frame = step(hmfr);
 step(hvp, frame);
 end
 close(hmfr);
 close(hvp);