# Final Project Mata Kuliah Pemrograman Berorientasi Objek
Nama Anggota Kelompok :
- 1917051022 Hans Christian Herwanto 
- 1917051024 Ardella Dean Awalia     
- 1917051059 Raymond Faraz Yandika   

## <br> Member Account Application
---
> Sistem untuk arsip data anggota suatu fasilitas apartemen (fitness/gym misalnya) yang berisi ID (nomor anggota), Nama Lengkap, Nomor Telepon, tanggal lahir, dan tanggal habis masa keanggotaan, dan nomor apartement (bagi anggota yang memiliki unit di apartemen tersebut). 
---
Librari dan Tools yang digunakan dalam project ini :
- NetBeans IDE
- sqlite-jdbc-3.34.0.jar
- SQLite Studio
- Scene Builder
- Microsoft Visual Studio extensions :
  - Markdown All in One
  - Markdown Preview Enchanced
  - Live Server

# <br> Desain
> Untuk melihat diagram di bawah, install plugin mermaid-diagram di  https://github.com/Redisrupt/mermaid-diagrams

## <br> Class Diagram
---
```mermaid
classDiagram
    Member <|-- ApartementOwner
    Member <|-- Individual
    Member "1"--o"1" Membership : has
    class Member{
      <<abstract>>
    -int id
    -String name
    -int phonenum
    +Membership membership
    +getId()
    +setId(int id)
    +getName()
    +setName(String name)
    +getPhonenum()
    +setPhonenum(long phonenum)
    +getMembership()
    +setMembership()
    +idProperty()
    +nameProperty()
    +phonenumProperty()
    }

    class ApartementOwner{
      -string apartementnum
      +getApartementnum()
      +setApartementnum(int apartementnum)
      +apartementnumProperty()
    }

    class Individual{
      -string birthdate
      +getBirthdate()
      +setBirthdate(String birthdate)
      +birthdateProperty()
    }

    class Membership{
      +string expirationdate
      +getExpirationDate()
      +setExpirationDate(String expirationDate)
      +expirationDateProperty()
      +renewMembership(String update)
    }
            
```

## <br> ER Diagram
---
```mermaid
erDiagram
    MEMBER ||--|| APARTEMENT-OWNER : is
    MEMBER ||..|| INDIVIDUAL : is
    MEMBER ||--|| MEMBERSHIP : "has"
    MEMBER{
      int id
      string name
      int phonenum
    }
    APARTEMENT-OWNER{
      int apartementnum
    }
    INDIVIDUAL{
      string birthdate
    }
    MEMBERSHIP{
      string expirationdate
    }
```

## <br> Design Class Diagram for JavaFX and Database
---
```mermaid
classDiagram
    Member <|-- Individual
    Member <|-- ApartementOwner
    Member "1"--o"*" Membership : has
    Member o-- MemberDataModel : Data Modeling
    MemberDataModel <-- MemberFormController : Data Control
    MemberDataModel --> DBConnection : DB Connection
    MemberFormController <.. MemberForm : Form Control      

    class Member{
      <<abstract>>
      -int id
      -String name
      -int phonenum
      +Membership membership
      +getId()
      +setId(int id)
      +getName()
      +setName(String name)
      +getPhonenum()
      +setPhonenum(long phonenum)
      +getMembership()
      +setMembership()
      +idProperty()
      +nameProperty()
      +phonenumProperty()
    }
    
    class Individual{
      -string birthdate
      +getBirthdate()
      +setBirthdate(String birthdate)
      +birthdateProperty()
    }
    class ApartementOwner{
      -string apartementnum
      +getApartementnum()
      +setApartementnum(int apartementnum)
      +apartementnumProperty()
    }
    class Membership{
      +string expirationdate
      +getExpirationDate()
      +setExpirationDate(String expirationDate)
      +expirationDateProperty()
      +renewMembership(String update)
    }

    class MemberDataModel{
        Connection conn
        addMember(Individual holder)
        addMember(Apartement holder)
        getIndividual()
        getApartementOwner()
        renewMembership()
        nextMemberID()
        nextMemberOwnerID()
    }

    class MemberFormController{
        initialize()
        handleCloseProgram()
        handleClearIndividu()
        handleClearOwner()
        handleReloadIndividu()
        handleReloadOwner()
        handleSaveIndividu()
        handleSaveOwner()
        editExpDate()
        editExpDateOwner()
    }

    class DBConnection{
        -String SQCONN
        getConnection()
        createTable();
    }          
```