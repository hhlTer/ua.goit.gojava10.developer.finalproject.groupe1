package factorymanagment.service.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class SecurityService {

    private String username;

    public ModelAndView getSecurityModel(String uri, Authentication authentication){

        User user = getUser();
        username = user.getUsername();
        ModelAndView modelAndView = new ModelAndView(uri);
        modelAndView.addObject("user", user);
        modelAndView.addObject("username", user.getUsername());
        modelAndView.addObject("roles", getRolesString(user));
        return modelAndView;
    }

    public String getUsername(){
        return username;
    }

    private User getUser() {

        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();

        if (authentication == null){
            System.out.println("null");
            return null;
        }

        UsernamePasswordAuthenticationToken token = null;

        try {
            token = (UsernamePasswordAuthenticationToken) authentication;
            if (token == null){
                return null;
            }
            return (User) token.getPrincipal();
        } catch (ClassCastException e) {
            return null;
        }
    }

    private String getRolesString(User user){
        if (user == null){
            return "null";
        }
        Collection<GrantedAuthority> collection = user.getAuthorities();

        String result = collection.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        return result.length() == 0 ? "guest" : result;
    }
}
