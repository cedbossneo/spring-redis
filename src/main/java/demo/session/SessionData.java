package demo.session;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class SessionData implements Serializable {
    String twitterHandle;

    public SessionForm toForm() {
        return new SessionForm(twitterHandle);
    }

    public void saveForm(SessionForm profileForm) {
        twitterHandle = profileForm.twitterHandle;
    }
}
