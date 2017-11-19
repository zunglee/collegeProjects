/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

/**
 *
 * @author rajendra
 */
public class jobrating {
    
    float jobsperday;
    float accuracy;
    float problemSolvingSkills;
    float overtime;
    final float rjob = (float) .35;
    final float raccuracy = (float) .25;
    final float rproblemSolvingsKills = (float) .25;
    final float rovertime = (float) .15;

    float calculatejobrating() {
        return (float) (jobsperday * rjob + accuracy * raccuracy + problemSolvingSkills * rproblemSolvingsKills + overtime * rovertime);
    }
    
    
}
