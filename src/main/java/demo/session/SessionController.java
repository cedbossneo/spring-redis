package demo.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class SessionController {

    private SessionData userProfileSession;

    @Autowired
    public SessionController(SessionData userProfileSession) {
        this.userProfileSession = userProfileSession;
    }

    @ModelAttribute
    public SessionForm getSessionForm() {
        return userProfileSession.toForm();
    }

    @RequestMapping("/")
    public String displayProfile() {
        return "index";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String saveProfile(@Valid SessionForm profileForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "index";
        }
        userProfileSession.saveForm(profileForm);
        return "redirect:/";
    }
}
