function varargout = try1(varargin)
% TRY1 MATLAB code for try1.fig
%      TRY1, by itself, creates a new TRY1 or raises the existing
%      singleton*.
%
%      H = TRY1 returns the handle to a new TRY1 or the handle to
%      the existing singleton*.
%
%      TRY1('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in TRY1.M with the given input arguments.
%
%      TRY1('Property','Value',...) creates a new TRY1 or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before try1_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to try1_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help try1

% Last Modified by GUIDE v2.5 16-Nov-2013 14:30:03

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @try1_OpeningFcn, ...
                   'gui_OutputFcn',  @try1_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT EDIT


% --- Executes just before try1 is made visible.
function try1_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to try1 (see VARARGIN)

% Choose default command line output for try1
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes try1 wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = try1_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;



function edit1_Callback(hObject, eventdata, handles)
% hObject    handle to edit1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit1 as text
%        str2double(get(hObject,'String')) returns contents of edit1 as a double


% --- Executes during object creation, after setting all properties.
function edit1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
[filename, foldername] = uigetfile({'*.*'}, 'Select file');
if filename ~= 0
vid = fullfile(foldername, filename);
end

guidata(hObject, handles);

set(handles.edit1,'String',vid)
set(handles.pushbutton1,'UserData',vid);



function edit2_Callback(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit2 as text
%        str2double(get(hObject,'String')) returns contents of edit2 as a double


% --- Executes during object creation, after setting all properties.
function edit2_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in pushbutton2.
function pushbutton2_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
[filename, foldername] = uigetfile({'*.*'}, 'Select file');
if filename ~= 0
imag = fullfile(foldername, filename);
end
set(handles.edit2,'String',imag)
set(handles.pushbutton2,'UserData',imag);
fid = fopen('D:/image1.txt','wt');
fprintf(fid,'%s',get(handles.edit2,'String'))
fclose(fid);
guidata(hObject, handles);




% --- Executes on button press in pushbutton3.
function pushbutton3_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
vid=get(handles.pushbutton1,'UserData');
imag=get(handles.pushbutton2,'UserData');

workingDir = 'C:\Users\level\Documents\MATLAB';
[status, message, messageid]=rmdir(fullfile(workingDir,'images'),'s');
mkdir('C:\Users\level\Documents\MATLAB\images');

shuttleVideo = VideoReader(vid);
for ii = 1:shuttleVideo.NumberOfFrames
    img = read(shuttleVideo,ii);

    % Write out to a JPEG file (img1.jpg, img2.jpg, etc.)
    imwrite(img,fullfile(workingDir,'images',sprintf('img%d.hdf',ii)));
    if ii==1
        imwrite(img,fullfile(workingDir,'images','sample.jpg'));
    end
end
imageNames = dir(fullfile(workingDir,'images','*.hdf'));
imageNames = {imageNames.name}';
imageStrings = regexp([imageNames{:}],'(\d*)','match');
imageNumbers = str2double(imageStrings);
[~,sortedIndices] = sort(imageNumbers);
sortedImageNames = imageNames(sortedIndices);
r=uint8(1);
c=uint8(1);

watermark=imread(imag);
 sz=size(watermark);

 samp=imread(fullfile(workingDir,'images','sample.jpg'));
 xx=size(samp);
 row=uint8(xx(1)/2); 
 col=uint8(xx(2)/2);
 
a=[1 row 1 row];
b=[1 1 col col];
sz(1)
sz(2)
for jj = 1:1:length(sortedImageNames)
        img = imread(fullfile(workingDir,'images',sortedImageNames{jj}));
        img=im2double(img);
        [ll,lh,hl,hh] = dwt2(img,'haar'); 
        
        
            for z= 1:1:4
                if r< (sz(1)+1)
              
              
            
                hh(a(z),b(z),1)=watermark(r,c)*5.0;
                
                hh(a(z),b(z),2)=watermark(r,c)*5.0;
                hh(a(z),b(z),3)=watermark(r,c)*5.0;
               
                c=c+1;
                  if c>sz(2) 
                        r=r+1;
                        c=1;
                  end
           
            end
       end
            
         
            X=idwt2(ll,lh,hl,hh,'haar');
      
              imwrite(X,fullfile(workingDir,'images',sprintf('img%d.hdf',jj)));
          
end
            
          
   
          

%{
img1 = imread(fullfile(workingDir,'images','img1.hdf'));
      img1=im2double(img1);
        [a,b,c,d] = dwt2(img1,'haar'); 
           
        for z = 1:1:39
            uint8(d(z,z))
        end
%}

outputVideo = VideoWriter(fullfile(workingDir,'shuttle_out'),'MPEG-4');
outputVideo.FrameRate = shuttleVideo.FrameRate;
open(outputVideo);
for ii = 1:length(sortedImageNames)
    img = imread(fullfile(workingDir,'images',sortedImageNames{ii}));
    writeVideo(outputVideo,img);
end
close(outputVideo);
msgbox('Embedding Complete!!');
implay('shuttle_out.mp4');


% --- Executes on button press in pushbutton4.
function pushbutton4_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
handles.s1=main;
handles.s2=try1;
h2=guidata(handles.s2);
h2.prev = handles.s1;
guidata(handles.s2,h2);
set(handles.s2,'Visible','Off');
set(handles.edit1,'String',' ');
set(handles.edit2,'String',' ');


% --- Executes on button press in pushbutton5.
function pushbutton5_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
vid=get(handles.pushbutton1,'UserData');
implay(vid)


% --- Executes on button press in pushbutton6.
function pushbutton6_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton6 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
imag=get(handles.pushbutton2,'UserData');
axes (handles.axes1);
set(handles.axes1,'visible','on');
img=imread(imag);
imshow(img, 'Parent', handles.axes1)
% --- Executes during object creation, after setting all properties.
function axes1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to axes1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: place code in OpeningFcn to populate axes1



function edit3_Callback(hObject, eventdata, handles)
% hObject    handle to edit3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit3 as text
%        str2double(get(hObject,'String')) returns contents of edit3 as a double


% --- Executes during object creation, after setting all properties.
function edit3_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end
