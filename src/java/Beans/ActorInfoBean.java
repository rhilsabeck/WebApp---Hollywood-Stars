
package Beans;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 *
 * @author Ryan Hilsabeck
 */
@ManagedBean
@ApplicationScoped
public class ActorInfoBean 
{

    private final Map<String, Integer> actorMap;
  
    //create map that will store the names that appear in drop down select
    //menu that will be the keys to the map, and integers that will be the
    //values and will help select the correct image file and description
    //fill when that name is selected
    public ActorInfoBean() 
    {
        actorMap = new LinkedHashMap<>();
        String[] keys = {"Please pick an actor","Cate Blanchett", "Daniel Day Lewis", "Jennifer Lawrence",
                    "Leonardo DiCaprio", "Meryl Streep", "Russell Crowe"};
        for(int k = 0; k < keys.length; k++)
        {
            actorMap.put(keys[k],Integer.valueOf(k));
        }
    }

    /**
     * @return the actorMap
     */
    public Map<String, Integer> getActorMap() {
        return actorMap;
    }
    
}
