package gr.teicm.koala;

import java.awt.event.MouseEvent;
import java.util.EventListener;

public interface IEventListener extends EventListener
{
    void mouseClicked(MouseEvent event);
}
