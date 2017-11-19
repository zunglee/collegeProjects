/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pro;

/**
 *
 * @author rajendra
 */
public class socialrating {
    
    float interaction;
    float teamwork;
    float communiactionSkills;
    final float rinteration = (float) 0.45;
    final float rteamwork = (float) 0.40;
    float rcommunicationSkills = (float) 0.15;

    float calculateSocialRating() {
        return (interaction * rinteration + teamwork * rteamwork + communiactionSkills * rcommunicationSkills);
    }
    
}
