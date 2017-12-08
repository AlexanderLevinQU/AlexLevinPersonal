'''
Meteorite GUI
Alex Levin


This code makes a simple GUI that takes a meteorite's ID number,
spits out the resulting meteor from DB, along with info,
then opens meteor's landing location in google maps
'''


import sys
import webbrowser #module for opening urls
import tkMessageBox #used for popup windows
from _sqlite3 import connect
import sqlite3
from Tkconstants import TOP
from Tkinter import StringVar
from Tkinter import *
import ttk
from _tkinter import create
from matplotlib.pyplot import waitforbuttonpress
#Python interpreter compatibility script
#imports correct tkinter module for python version
py_vers = sys.version
if "2.7" in py_vers:
    from Tkinter import *
    print("running Tkinter for python2.7")
elif "3.3" in py_vers or "3.4" in py_vers:
    from tkinter import *
    print("running tkinter for python3")


ATTRIBS = ["ID", "Latitude", "Longitude", "Class", "Name", "Fall", "year", "Mass", "NameType" ]
##Actual data from a query goes 0 = ID, 1 =lat, 2 = long, 3 = Class,
## 4 = id REPEAT ID IGNORE, 5=fall, 6=year, 7=mass, 8= NAME REPEAT IGNORE,
## 9=NameType

#functions go here
def createTable(data):
    newWindow = Tk()
    newWindow.title("Table")
    tv = ttk.Treeview(newWindow, height=1000)
    tv['columns'] = (ATTRIBS[0], ATTRIBS[1], ATTRIBS[2], ATTRIBS[3], ATTRIBS[4], ATTRIBS[5], ATTRIBS[6], ATTRIBS[7], ATTRIBS[8])
    ##So everything starts in left
    tv.heading("#0",anchor='w')
    tv.column("#0", stretch=NO, width=0, anchor="w")
    ##ID
    tv.heading(ATTRIBS[0], text="ID")
    tv.column(ATTRIBS[0], anchor='center', width=70)
    ##LAT
    tv.heading(ATTRIBS[1], text="Latitude")
    tv.column(ATTRIBS[1], anchor='center', width=70)
    ##Long
    tv.heading(ATTRIBS[2], text="Longitude")
    tv.column(ATTRIBS[2], anchor='center', width=70)
    ##Class
    tv.heading(ATTRIBS[3], text="Class")
    tv.column(ATTRIBS[3], anchor='center', width=70)
    ##Name
    tv.heading(ATTRIBS[4], text="Name")
    tv.column(ATTRIBS[4], anchor='center', width=70)
    ##Fall
    tv.heading(ATTRIBS[5], text="Fall")
    tv.column(ATTRIBS[5], anchor='center', width=70)
    ##Year
    tv.heading(ATTRIBS[6], text="year")
    tv.column(ATTRIBS[6], anchor='center', width=235)
    ##Mass
    tv.heading(ATTRIBS[7], text="Mass")
    tv.column(ATTRIBS[7], anchor='center', width=70)
    ##NameType
    tv.heading(ATTRIBS[8], text="NameType")
    tv.column(ATTRIBS[8], anchor='center', width=70)
    
    newWindow.columnconfigure(0, weight=1)
    newWindow.rowconfigure(0, weight=1)
    tv.grid(row=0, column=0, columnspan=9, padx=5, pady=5)
    
    for info in data:
        tv.insert("","end",values = (info[0],info[1],info[2],info[3],info[5],info[6],info[7],info[8],info[10]))
    
    

def fallSearch():
    theFall = fall.get()
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    command = '''SELECT *
                 FROM Geolocation G, Meteor M, Names N
                 Where G.ID = M.ID AND M.name = N.name AND M.fall = ? '''
    
    cursor.execute(command, [theFall])
    data = cursor.fetchall()
    createTable(data)
    db.close()
def yearSearch():
    yearTime = yearTime.get()
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    command = '''SELECT *
                 FROM Geolocation G, Meteor M, Names N
                 Where G.ID = M.ID AND M.name = N.name AND M.year = ? '''
    
    cursor.execute(command, [yearTime])
    data = cursor.fetchall()
    createTable(data)
    db.close()
def massSearch():
    theMass = mass.get()
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    command = '''SELECT *
                 FROM Geolocation G, Meteor M, Names N
                 Where G.ID = M.ID AND M.name = N.name AND M.mass = ? '''
    
    cursor.execute(command, [theMass])
    data = cursor.fetchall()
    createTable(data)
    db.close()
def nameTypeSearch():
    theNameType = nameType.get()
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    command = '''SELECT *
                 FROM Geolocation G, Meteor M, Names N
                 Where G.ID = M.ID AND M.name = N.name AND N.nametype = ? '''
    
    cursor.execute(command, [theNameType])
    data = cursor.fetchall()
    createTable(data)
    db.close()
def recLongSearch():
    therecLong = recLong.get()
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    command = '''SELECT *
                 FROM Geolocation G, Meteor M, Names N
                 Where G.ID = M.ID AND M.name = N.name AND G.reclong = ? '''
    
    cursor.execute(command, [therecLong])
    data = cursor.fetchall()
    createTable(data)
    db.close()
def recLatSearch():
    therecLat = recLat.get()
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    command = '''SELECT *
                 FROM Geolocation G, Meteor M, Names N
                 Where G.ID = M.ID AND M.name = N.name AND G.reclat = ? '''
    
    cursor.execute(command, [therecLat])
    data = cursor.fetchall()
    createTable(data)
    db.close()
def recClassSearch():
    theRecClass = recClass.get()
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    command = '''SELECT *
                 FROM Geolocation G, Meteor M, Names N
                 Where G.ID = M.ID AND M.name = N.name AND G.recClass = ? '''
    
    cursor.execute(command, [theRecClass])
    data = cursor.fetchall()
    createTable(data)
    db.close()

def urlBuilder(lat, long): #take lat and long from query result as parameters, and construct a url from that
    site_start = 'https://www.google.com/maps/?q='
    fin = site_start + str(lat) + ',' + str(long)
    print fin
    return fin


def searchDB():
    '''this will search the database with parameters given by search bar, and return either the db info in a popup,
    or an error message if meteor not found'''
    ##Connect to DB
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    ##Check if you got ID or Name
    try:
        val = int(searched.get())
        isID = True
    except ValueError:
        isID = False
    
    if isID == False:
        try:
            val = int(searched2.get())
            isID = True
        except ValueError:
            isID = False
        
    command = ''' ''' #declare before so can use after
    command2 = ''' ''' #declare before so can use after
    if isID == True:
        command = '''SELECT *
                     FROM Geolocation G, Meteor M, Names N
                     Where G.ID = M.ID AND M.name = N.name AND m.ID = ? '''
        command2 = '''SELECT recLat, recLong
                     FROM Geolocation G
                     WHERE G.ID = ?'''
    else:
        command = '''SELECT *
                     FROM Geolocation G, Meteor M, Names N
                     WHERE G.ID = M.ID AND M.name = N.name AND m.name = ? '''
        command2 = '''SELECT recLong, recLat
                     FROM Geolocation G, Meteor M, Names N
                     WHERE G.ID = M.ID AND M.name = N.name AND m.name = ? '''
    
    if isID == True:    
        cursor.execute(command, [searched.get()])
    else:
        cursor.execute(command, [searched2.get()])
        
    data = cursor.fetchone()
    #makes a popuptable
    newWindow = Tk()
    tv = ttk.Treeview(newWindow, height=1000)
    tv['columns'] = (ATTRIBS[0], ATTRIBS[1], ATTRIBS[2], ATTRIBS[3], ATTRIBS[4], ATTRIBS[5], ATTRIBS[6], ATTRIBS[7], ATTRIBS[8])
    ##So everything starts in left
    tv.heading("#0",anchor='w')
    tv.column("#0", stretch=NO, width=0, anchor="w")
    ##ID
    tv.heading(ATTRIBS[0], text="ID")
    tv.column(ATTRIBS[0], anchor='center', width=70)
    ##LAT
    tv.heading(ATTRIBS[1], text="Latitude")
    tv.column(ATTRIBS[1], anchor='center', width=70)
    ##Long
    tv.heading(ATTRIBS[2], text="Longitude")
    tv.column(ATTRIBS[2], anchor='center', width=70)
    ##Class
    tv.heading(ATTRIBS[3], text="Class")
    tv.column(ATTRIBS[3], anchor='center', width=70)
    ##Name
    tv.heading(ATTRIBS[4], text="Name")
    tv.column(ATTRIBS[4], anchor='center', width=70)
    ##Fall
    tv.heading(ATTRIBS[5], text="Fall")
    tv.column(ATTRIBS[5], anchor='center', width=70)
    ##Year
    tv.heading(ATTRIBS[6], text="year")
    tv.column(ATTRIBS[6], anchor='center', width=235)
    ##Mass
    tv.heading(ATTRIBS[7], text="Mass")
    tv.column(ATTRIBS[7], anchor='center', width=70)
    ##NameType
    tv.heading(ATTRIBS[8], text="NameType")
    tv.column(ATTRIBS[8], anchor='center', width=70)
    
    newWindow.columnconfigure(0, weight=1)
    newWindow.rowconfigure(0, weight=1)
    tv.grid(row=0, column=0, columnspan=9, padx=5, pady=5)
    
    tv.insert("","end",values = (data[0],data[1],data[2],data[3],data[5],data[6],data[7],data[8],data[10]))

    ## now need the recLong and the recLat
    recLong = 0
    recLat = 0
    for tuple in cursor.execute(command2, [searched.get()]):
         recLong = tuple[0]
         recLat = tuple[1]
    db.close()
    return webbrowser.open(urlBuilder(recLat,recLong))#insert query result lat,long here

def deletion():
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    try:
        val = int(delete.get())
        isID = True
    except ValueError:
        isID = False
    if isID == True:
        #Use comma to avoid SQL injection ?
        name = cursor.execute("SELECT name FROM Meteor WHERE ID = ?", (delete.get(),))
        db.commit()
        realName = " "
        for tuple in name:
            realName = str(tuple[0])
        print realName
        cursor.execute("DELETE FROM Meteor WHERE ID = ?", (delete.get(),))
        db.commit()
        cursor.execute("DELETE FROM GeoLocation WHERE ID = ?", (delete.get(),))
        db.commit()
        ## GET name from searched
        cursor.execute("DELETE FROM Names WHERE name = ?", (realName,))
        db.commit()
    else:
        ##GET ID FROM NAME
        id = cursor.execute("SELECT ID FROM Meteor WHERE name = ?", (delete.get(),))
        db.commit()
        realID = 0
        #Use comma to avoid ?
        cursor.execute("DELETE FROM Meteor WHERE name = ?", (delete.get(),))
        db.commit()
        cursor.execute("DELETE FROM Names WHERE name = ? ", (delete.get(),))
        db.commit()
        cursor.execute("DELETE FROM GeoLocation WHERE ID = ?", (realID,))
        db.commit()
        
    db.close()

def insertion():
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    id = idz.get()
    theName = name.get()
    recLat = reclatE.get()
    recLong = reclongE.get()
    
    ##Insert Values into correct tables
    cursor.execute("INSERT INTO Meteor (ID, name) VALUES(?,?)",
                   (id, theName))
    cursor.execute("INSERT INTO GeoLocation(ID, reclat, reclong) VALUES(?,?,?)",
                   (id, recLat, recLong))
    cursor.execute("INSERT INTO Names(name, nametype) VALUES(?,?)", 
                   (theName, "Valid"))
    db.commit()
    db.close()

def searchAll():
    db = sqlite3.connect("NasaDB.sqlite")
    cursor = db.cursor()
    theid = searched.get()
    therecLat = recLat.get()
    therecLong = recLong.get()
    therecClass = recClass.get()
    theName = searched2.get()
    theFall = fall.get()
    theYear = yearTime.get()
    theMass = mass.get()
    theNameType = nameType.get()
    
    ##Put them all in an array check if they have none
    values = [theid, therecLat, therecLong, therecClass, theName, theFall, theYear, theMass, theNameType]
    ##If they do add the where to the string for execution 
    for i in range(0,8):
        if values[i] is not None:
            pass

################################################################
######################GUI CREATION##############################
################################################################
root = Tk()#initialize main window
root.title("Meteor DB GUI")#title it
root.minsize(width=400, height=200)#set dimensions
root.maxsize(width=800, height=600)

#make an ID search bar
searched = StringVar()
searched2 = StringVar()
id_searchBar = Entry(root, textvariable=searched, width =20)
id_searchBar.grid(row=1, column=0)

#initialize ID search button
id_search_button = Button(root, text="Search by ID", width=20, command = searchDB)
id_search_button.grid(row=0, column=0)

# make an name search bar
name_search_bar = Entry(root,textvariable=searched2, width=20)
name_search_bar.grid(row=3, column=0)

# initialize name search button
name_search_button = Button(root, text="Search by Name", width=20, command=searchDB)
name_search_button.grid(row=2, column=0)

##year##
yearTime = StringVar()
year_search_button = Button(root, text="Search by TimeStamp(y)", width=20, command=yearSearch)
year_search_button.grid(row=0, column=1)

year_entry = Entry(root, textvariable=yearTime, width=20)
year_entry.grid(row=1, column=1)

###FALL##
fall = StringVar()
fall_search_button = Button(root, text="Search if Found/Fell", width = 20, command=fallSearch)
fall_search_button.grid(row=2, column=1)

fall_Entry = Entry(root, textvariable = fall, width = 20)
fall_Entry.grid(row= 3, column=1)

##Mass##
mass = StringVar()
mass_search_button= Button(root, text="Search by Mass", width=20, command=massSearch)
mass_search_button.grid(row=2, column=2)

mass_Entry = Entry(root, textvariable=mass, width=20)
mass_Entry.grid(row=3, column=2)

##NameType
nameType = StringVar()
nameType_button = Button(root, text="Search by NameType", width=20, command=nameTypeSearch)
nameType_button.grid(row=2,column=3)

nameType_entry = Entry(root, textvariable=nameType, width=20)
nameType_entry.grid(row=3, column=3)

##recLong
recLong = StringVar()
recLong_button= Button(root, text="Search by Longitude", width=20, command=recLongSearch)
recLong_button.grid(row=0, column=2)

recLongEntry = Entry(root, textvariable=recLong, width=20)
recLongEntry.grid(row=1, column=2)

##recLat
recLat = StringVar()
recLat_button= Button(root, text="Search by Latitude", width=20, command=recLatSearch)
recLat_button.grid(row=0, column=3)

recLatEntry= Entry(root, textvariable=recLat, width=20)
recLatEntry.grid(row=1, column=3)

##recClass
recClass = StringVar()
recClass_button= Button(root, text="Search by recClass", width=20, command=recClassSearch)
recClass_button.grid(row=0, column=4)

recClass_Entry = Entry(root, textvariable=recClass, width=20)
recClass_Entry.grid(row=1, column=4)

#initialize insert search
idz = StringVar()
name = StringVar()
reclatE = StringVar()
reclongE = StringVar()
id_entry = Entry(root, textvariable=idz, width= 20)
name_entry = Entry(root, textvariable=name, width= 20)
recLat_entry = Entry(root, textvariable=reclatE, width=20)
recLong_entry = Entry(root, textvariable=reclongE, width=20)
id_entry.grid(row=7, column=1)
name_entry.grid(row=7, column=2)
recLat_entry.grid(row=7, column=3)
recLong_entry.grid(row=7, column=4)

id_entry_label = Label(text="ID")
name_entryLabel= Label(text="Name")
reclatE_label = Label(text="Latitude")
recLong_label = Label(text="Longitude")
id_entry_label.grid(row=6, column=1)
name_entryLabel.grid(row=6, column=2)
reclatE_label.grid(row=6, column=3)
recLong_label.grid(row=6, column=4)

#inititalize insert button
insert_button = Button(root, text="Add", width=10, command=insertion)
insert_button.grid(row=7, column=0)

#initiazlize deletion
##Have to change StringVar() for this part 
delete = StringVar()
deletionBar = Entry(root, textvariable=delete, width = 20)
deletionBar.grid(row=5, column = 1)
#inititalize delete button
delete_button = Button(root, text="Delete", width=10, command=deletion)
delete_button.grid(row=5, column=0)

#run the window in loop
root.mainloop()
