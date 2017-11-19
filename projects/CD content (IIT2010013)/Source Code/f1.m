function varargout = f1(varargin)
% F1 M-file for f1.fig
%      F1, by itself, creates a new F1 or raises the existing
%      singleton*.
%
%      H = F1 returns the handle to a new F1 or the handle to
%      the existing singleton*.
%
%      F1('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in F1.M with the given input arguments.
%
%      F1('Property','Value',...) creates a new F1 or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before f1_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to f1_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% Edit the above text to modify the response to help f1

% Last Modified by GUIDE v2.5 03-Apr-2013 13:37:10

% Begin initialization code - DO NOT EDIT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @f1_OpeningFcn, ...
                   'gui_OutputFcn',  @f1_OutputFcn, ...
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


% --- Executes just before f1 is made visible.
function f1_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to f1 (see VARARGIN)

% Choose default command line output for f1
handles.output = hObject;
handles.next=1;
handles.prev=1;



% Update handles structure
guidata(hObject, handles);

% UIWAIT makes f1 wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = f1_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;


% --- Executes on button press in pushbutton1.
function pushbutton1_Callback(hObject, eventdata, handles)
handles.s1=f1;
handles.s2=f2;
h1=guidata(handles.s1);
h1.next = handles.s2;
guidata(handles.s1,h1);

set(handles.next,'Visible','On');
set(handles.output,'Visible','Off');

% hObject    handle to pushbutton1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in pushbutton2.
function pushbutton2_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
