

package Beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Ryan
 */
@ManagedBean
@RequestScoped
public class StarInfo 
{
    private final Map<String, String> starMap;
    private final Map<String, String> starDescMap;
    private String selectedStarImage = "images/StarterImage.jpg";
    private String selectedStarDescription = "StarterImage.txt";
    public StarInfo() 
    {
        starMap = new LinkedHashMap<>();
        starDescMap = new LinkedHashMap<>();
        String [] keys = {"Please pick an actor","Cate Blanchett", "Daniel Day Lewis", "Jennifer Lawrence",
                    "Leonardo DiCaprio", "Meryl Streep", "Russell Crowe"};
        String[] files = {"images/StarterImage.jpg","images/CateBlanchett.jpg", "images/DanielDayLewis.jpg" , "images/JenniferLawrence.jpg",
                  "images/LeonardDiCaprio.jpg", "images/MerylStreep.jpg", "images/RussellCrowe.jpg"};
        String[] descriptionFiles = {"/WEB-INF/StarterImage.txt", "/WEB-INF/CateBlanchett.txt", "/WEB-INF/DanielDayLewis.txt",
                            "/WEB-INF/JenniferLawrence.txt", "/WEB-INF/LeonardoDiCaprio.txt","/WEB-INF/MerylStreep.txt",
                            "/WEB-INF/RussellCrowe.txt"};
        
        for(int k = 0; k < keys.length; k++)
        {
            starMap.put(keys[k], files[k]);
        }
        
        for(int k = 0; k < files.length; k++)
        {
            starDescMap.put(files[k], descriptionFiles[k]);
        }
    }
    
    public Map<String,String> getStarMap()
    {
        return starMap;
    }
    
    public String getSelectedStarImage()
    {
        return selectedStarImage;
    }
    
    public void setSelectedStarImage(String selectedStarImage)
    {
        this.selectedStarImage = selectedStarImage;
    }
    
    public String getSelectedStarDescription() throws FileNotFoundException, IOException
    {
        selectedStarDescription = starDescMap.get(selectedStarImage);
        
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        
            String realPath = sc.getRealPath(selectedStarDescription);
            //Below will use a filereader to read the text file and put it into
            //a stringbuilder
            File file = new File(realPath);
            FileReader fileReader = new FileReader(file);
            BufferedReader buffReader = new BufferedReader(fileReader);
            String line;
            StringBuilder stringBuilder = new StringBuilder();
            
            while((line = buffReader.readLine()) != null)
            {
                stringBuilder.append(line);
            }
            
            return stringBuilder.toString();
        
    }
    
}
