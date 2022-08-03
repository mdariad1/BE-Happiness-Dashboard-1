package mapper;

import com.ibm.ro.tm.apprenticeship.poll.metter.dto.UserDTO;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.CustomException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.AnswerRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.*;

@Configuration
public class UserMapper {

    @Autowired
    public UserMapper() {
    }

    public static User toEntity(UserDTO userDto){
        User user = new User();

        user.setName(userDto.getName());
        user.setRole(userDto.getRole());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public static UserDTO toDto(User user){
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setRole(user.getRole());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        return userDto;
    }

    public static Set<User> toSetEntity(Set<UserDTO> userDtos){
        Set<User> users = new HashSet<>();
        Iterator<UserDTO> it = userDtos.iterator();
        while(it.hasNext()){
            User user = UserMapper.toEntity(it.next());
            users.add(user);
        }
        return users;
    }

    public static Set<UserDTO> toSetDto(Set<User> users){
        Set<UserDTO> userDtos = new HashSet<>();
        Iterator<User> it = users.iterator();
        while(it.hasNext()){
            UserDTO user = UserMapper.toDto(it.next());
            userDtos.add(user);
        }
        return userDtos;

    }
}
