
package Beans;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

/**
 *
 * @author Ryan Hilsabeck
 */
@ManagedBean
@RequestScoped
public class ActorAjaxBean 
{
    private Integer actorIndex;
    private String actorDescription;
    //Consturctor that will set default index and description when the 
    //app starts
    public ActorAjaxBean() 
    {
    actorIndex = 0;
    actorDescription = "Please select an actor from the drop down list Please!!!!";
    }

    /**
     * @return the actorIndex
     */
    public Integer getActorIndex() {
        return actorIndex;
    }

    /**
     * @param actorIndex the actorIndex to set
     */
    public void setActorIndex(Integer actorIndex) {

            this.actorIndex = actorIndex;
        

    }

    /**
     * @return the actorDescription
     * @throws java.io.FileNotFoundException
     * This will get the servlet context from the facescontext, take the index
     * of the actor selected and get the correct text file, and read the file
     * and send it to the inputtextbox
     */
    public String getActorDescription() throws FileNotFoundException, IOException {
        
        
     ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

     String realPath = sc.getRealPath("/WEB-INF/actor" + actorIndex +".txt");
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
            
           actorDescription = stringBuilder.toString();
        return actorDescription;
    }
    
}
