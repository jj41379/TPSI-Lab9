package wizut.tpsi.lab9;

import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wizut.tpsi.lab9.BlogPost;
import wizut.tpsi.lab9.BlogRepository;

@Controller
public class BlogPostController {
    @Autowired
    private BlogRepository blogRepo;
    
    @GetMapping("/")
    public String getPosts(Model model) throws SQLException, SQLException {
    model.addAttribute("posts", blogRepo.getAllPosts());
    return "index";
    }
    
    @PostMapping("/newpost")
    public String newPost(BlogPost post) throws SQLException {
    blogRepo.createPost(post);
    return "redirect:/";
}
   
     @GetMapping("/deletepost")
    public String deletePost(@RequestParam("id") long id) throws SQLException {
    blogRepo.deletePost(id);
    return "redirect:/";
    }
}
