/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.middlewave.simplekafkaintegrator.listener;

/**
 *
 * @author fazeem
 */
public interface ConsumerListener {
    
    public String receiveMessage(String message);
    
}
