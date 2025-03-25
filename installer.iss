[Setup]
AppName=Gestion d'Emprunts de Livres
AppVersion=1.0
DefaultDirName={pf}\Gestion d'Emprunts de Livres
DefaultGroupName=Gestion d'Emprunts de Livres
OutputDir=output
OutputBaseFilename=Setup_GestionEmprunts
Compression=lzma
SolidCompression=yes

[Files]
Source: "dist\EmpruntsLivres.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "dist\lib\*"; DestDir: "{app}\lib"; Flags: ignoreversion recursesubdirs

[Icons]
Name: "{group}\Lancer l'application"; Filename: "javaw.exe"; Parameters: "-jar ""{app}\EmpruntsLivres.jar"""
Name: "{group}\Désinstaller Gestion d'Emprunts de Livres"; Filename: "{uninstallexe}"

[Run]
Filename: "javaw.exe"; Parameters: "-jar ""{app}\EmpruntsLivres.jar"""; Description: "Lancer Gestion d'Emprunts de Livres"; Flags: nowait postinstall skipifsilent

[Code]
function IsJavaInstalled(): Boolean;
var
  ErrorCode: Integer;
begin
  Result := Exec('javaw.exe', '-version', '', SW_HIDE, ewWaitUntilTerminated, ErrorCode);
end;

function InitializeSetup(): Boolean;
var
  ErrorCode: Integer;
begin
  if not IsJavaInstalled() then begin
    MsgBox('Java n''est pas installé sur votre ordinateur.' #13#13 +
           'Vous allez être redirigé vers la page de téléchargement.', mbError, MB_OK);
    ShellExec('open', 'https://www.java.com/fr/download/', '', '', SW_SHOWNORMAL, ewNoWait, ErrorCode);
    Result := False; 
  end else begin
    Result := True; 
  end;
end;
