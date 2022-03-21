public class Assignment2 
{
    /*
     *  NETTRIX CATALOGUE!
     */   
    private String[] catalogue=
    {
        "MOVIE#2001: A Space Odyssey#1968",
        "GAME#The Witcher 3#2015",
        "TV-SERIES#Stranger Things (Season 1)#2016",
        "GAME#Minecraft#2009",
        "ALBUM#All Eyez On Me#1996",
        "MOVIE#Star Trek II: The Wrath of Khan#1982",
        "ALBUM#Hand on the Torch#1993",
        "TV-Series#Black Mirror (Season 1)#2011",
        "GAME#Zork#1980",
        "ALBUM#Fetch the Bolt Cutters#20190",
        "MOVIEZ#The Irishman#2019",
        "GAME#Papers, Please#2013"
    }; 


    public void run()
    {
        int myYear=1999;
        int myTitleType=1;

        System.out.println("Printing names of existing titles in the catalog...");
        printTitleNames(myTitleType);
        System.out.println("------------");
        if (isThereMusicAfter(myYear))
        {
            System.out.println("There is some music after "+myYear);
        }
        else
        {
            System.out.println("Seriously, there is NO music after "+myYear);
        }

        System.out.println("------------");
        System.out.println("Printing report on catalog format...");
        System.out.println(getFormatReport());
        System.out.println("------------");
        System.out.println("Printing statistics on media release periods...");
        System.out.println(releasedTitlesHistogram());  
    }


    private void printTitleNames(int titleType)
    {
        if (titleType == 0){
            for(int i=0; i<catalogue.length; i++){
                int index_S = catalogue[i].indexOf("#");
                int index_E = catalogue[i].lastIndexOf("#");
                String title = catalogue[i].substring(index_S+1,index_E);
                System.out.println(title);
            }
        } else if (titleType == 1){
            for(int i=0; i<catalogue.length; i++){
                int index_S = catalogue[i].indexOf("#");
                int index_E = catalogue[i].lastIndexOf("#");
                String movie = catalogue[i].substring(0,index_S);
                    if (movie.equals("MOVIE")){
                        String title = catalogue[i].substring(index_S+1,index_E);
                        System.out.println(title);
                    }
            }        
        } else if (titleType == 2){
            for(int i=0; i<catalogue.length; i++){
                int index_S = catalogue[i].indexOf("#");
                int index_E = catalogue[i].lastIndexOf("#");
                String tv = catalogue[i].substring(0,index_S);
                    if (tv.equals("TV-SERIES")){
                        String title = catalogue[i].substring(index_S+1,index_E);
                        System.out.println(title);
                    }
            }    
        } else if (titleType == 3){
            for(int i=0; i<catalogue.length; i++){
                int index_S = catalogue[i].indexOf("#");
                int index_E = catalogue[i].lastIndexOf("#");
                String games = catalogue[i].substring(0,index_S);
                    if (games.equals("GAME")){
                        String title = catalogue[i].substring(index_S+1,index_E);
                        System.out.println(title);
                    }
            }    
        } else if (titleType == 4){
            for(int i=0; i<catalogue.length; i++){
                int index_S = catalogue[i].indexOf("#");
                int index_E = catalogue[i].lastIndexOf("#");
                String album = catalogue[i].substring(0,index_S);
                    if (album.equals("ALBUM")){
                        String title = catalogue[i].substring(index_S+1,index_E);
                        System.out.println(title);
                    }
            }    
        } else {
            System.out.println("Invalid Media Type");
        }
    }
    

    private boolean isThereMusicAfter(int year) 
    {
        if (year<=2019 && year>=1920){
            for(int i=0; i<catalogue.length; i++){
                int index_S = catalogue[i].indexOf("#");
                int index_END = catalogue[i].length();
                int index_E = catalogue[i].lastIndexOf("#");
                String album = catalogue[i].substring(0,index_S);
                String album_year = catalogue[i].substring(index_E+1, index_END);
                if ((album.equals("ALBUM"))){
                    if (Integer.parseInt(album_year)>year){
                        return true;
                    }      
                }
            }
        } else {
            return false;
        }
        return false;
    }


    private String getFormatReport()
    {
	String report = "";
        for(int i=0; i<catalogue.length; i++) {
            int index_S = catalogue[i].indexOf("#");
            int index_E = catalogue[i].lastIndexOf("#");
            int index_END = catalogue[i].length();
            String title = catalogue[i].substring(0,index_S);
            String year = catalogue[i].substring(index_E+1,index_END);
            if (title.equals("MOVIE")||title.equals("GAME")||title.equals("TV-SERIES")||title.equals("ALBUM")){
                if (Integer.parseInt(year)>=1920 && Integer.parseInt(year)<=2019) {
                    report += "Item #" + (i + 1) + " - OK";
                } else {
                    report += "Item #" + (i + 1) + " - Year incorrect or out of range";
                }
            } else {
                report += "Item #" + (i + 1) + " - Incorrect Media Type";
                if (Integer.parseInt(year)>=1920 && Integer.parseInt(year)<=2019) {
                    report += "";
                } else {
                    report += " & Year incorrect or out of range";
                }
            }
	report += "\n";      //New line character
        }
    return report;
    }


    private String releasedTitlesHistogram()
    {
        String hist = "";
        int count_1 = 0;
        int count_2 = 0;
        int count_3 = 0;
        int count_4 = 0;
        for(int i=0; i<catalogue.length; i++){
            int index_E = catalogue[i].lastIndexOf("#");
            int index_END = catalogue[i].length();
            String year = catalogue[i].substring(index_E+1, index_END);
                if (Integer.parseInt(year)>=1995 && Integer.parseInt(year)<=2019){
                    count_1++;
                } else if (Integer.parseInt(year)>=1970 && Integer.parseInt(year)<=1994){
                    count_2++;
                } else if (Integer.parseInt(year)>=1945 && Integer.parseInt(year)<=1969){
                    count_3++;
                } else if (Integer.parseInt(year)>=1920 && Integer.parseInt(year)<=1944){
                    count_4++;
                }
        }
        hist = ("Number of titles in year 1920 - 1944: " + count_4 + "\n" + "Number of titles in year 1945 - 1969: " + count_3 + "\n" + "Number of titles in year 1970 - 1994: " + count_2 + "\n" + "Number of titles in year 1995 - 2019: " + count_1);
    return hist;
    }  
}