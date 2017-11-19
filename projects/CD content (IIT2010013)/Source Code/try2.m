function varargout = try2(varargin)
% TRY2 MATLAB code for try2.fig
%      TRY2, by itself, creates a new TRY2 or raises the existing
%      singleton*.
%
%      H = TRY2 returns the handle to a new TRY2 or the handle to
%      the existing singleton*.
%
%      TRY2('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in TRY2.M with the given input arguments.
%
%      TRY2('Property','Value',...) creates a new TRY2 or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before try2_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to try2_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help try2

% Last Modified by GUIDE v2.5 25-Nov-2013 20:13:37

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @try2_OpeningFcn, ...
                   'gui_OutputFcn',  @try2_OutputFcn, ...
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


% --- Executes just before try2 is made visible.
function try2_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to try2 (see VARARGIN)

% Choose default command line output for try2
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes try2 wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = try2_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
[filename, foldername] = uigetfile({'*.*'}, 'Select file');
if filename ~= 0
vide = fullfile(foldername, filename);
end
guidata(hObject, handles);
[pathstr, name, ext] = fileparts(filename)
formatt=strcat(name,ext)
set(handles.edit1,'String',formatt)
set(handles.pushbutton1,'UserData',vide);
fid = fopen('imagefile1.txt','wt');
fprintf(fid,'%s',get(handles.edit1,'String'))
fclose(fid);
guidata(hObject, handles);



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


% --- Executes on button press in pushbutton2.
function pushbutton2_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
handles.s1=try2;
handles.s2=main;
h2=guidata(handles.s2);
h2.prev = handles.s1;
guidata(handles.s2,h2);
set(handles.s1,'Visible','Off');
set(handles.edit1,'String',' ');



% --- Executes on button press in pushbutton3.
function pushbutton3_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
str = fileread ('imagefile1.txt')

workingDir = 'C:\Users\level\Documents\MATLAB';
[status, message, messageid]=rmdir(fullfile(workingDir,'images2'),'s');
mkdir('C:\Users\level\Documents\MATLAB\images2');
shuttleVideo = VideoReader('shuttle_out.mp4');
p=uint8(1);
q=uint8(1);

for ii = 1:shuttleVideo.NumberOfFrames
    img = read(shuttleVideo,ii);

    % Write out to a JPEG file (img1.jpg, img2.jpg, etc.)
    imwrite(img,fullfile(workingDir,'images2',sprintf('img%d.hdf',ii)));
end
imageNames = dir(fullfile(workingDir,'images2','*.hdf'));
imageNames = {imageNames.name}';
imageStrings = regexp([imageNames{:}],'(\d*)','match');
imageNumbers = str2double(imageStrings);
[~,sortedIndices] = sort(imageNumbers);
sortedImageNames = imageNames(sortedIndices);

 samp=imread(fullfile(workingDir,'images','sample.jpg'));
 xx=size(samp);
 row=uint8(xx(1)/2); 
 col=uint8(xx(2)/2);
 imag=fileread('D://image1.txt');
 watermark=imread(imag);
 sz=size(watermark);


l=[1 row 1 row];
m=[1 1 col col];

for ii = 1:1:length(sortedImageNames)
    img = imread(fullfile(workingDir,'images2',sortedImageNames{ii}));
    
   if p<(sz(1)+1)
        %%img = imread(fullfile(workingDir,'images','img1.hdf'));
      img=im2double(img);
        [a,b,c,d] = dwt2(img,'haar'); 
           
        for z = 1:1:4
           
            mat(p,q)=uint8(d(l(z),m(z)));
            
            q=q+1;
            if q>sz(2) 
                p=p+1;
                q=1;
            end
            
        end
   end
end
mat
%imshow(mat)
wat=mat2gray(mat);

 imwrite(wat,fullfile(workingDir,'images2','out.jpg'));

img34=imread(fullfile(workingDir,'images2','out.jpg'));
imshow(img34);
 msgbox('Detection Successfully');
% --- Executes on button press in pushbutton5.
function pushbutton5_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
%axes (handles.axes1);
%set(handles.axes1,'visible','on');
%img=imread(fullfile(workingDir,'images2','out.jpg'));
%imshow(img);


% --- Executes during object creation, after setting all properties.
function axes1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to axes1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: place code in OpeningFcn to populate axes1
