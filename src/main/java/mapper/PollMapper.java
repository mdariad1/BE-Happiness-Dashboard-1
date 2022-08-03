package mapper;

import com.ibm.ro.tm.apprenticeship.poll.metter.dto.PollDTO;
import com.ibm.ro.tm.apprenticeship.poll.metter.dto.UserDTO;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.CustomException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.*;


@Configuration
public class PollMapper {


    private static UserService userService;
    private static UserRepository userRepo;

    @Autowired
    public PollMapper(UserService userService,UserRepository userRepo) {
        this.userService = userService;
        this.userRepo = userRepo;
    }

    public static Poll toEntity(PollDTO pollDto){
        Poll poll = new Poll();

        Optional<User> existingUser = userRepo.findById(pollDto.getUserId());
        if (!existingUser.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+pollDto.getUserId()+" not found");
        }
        User userEntity = existingUser.get();
        poll.setUser(userEntity);
        poll.setTopic(pollDto.getTopic());

        //poll.setAnswers(pollDto.getAnswers());
        return poll;
    }

    public static PollDTO toDto(Poll poll){
        PollDTO pollDto = new PollDTO();
        pollDto.setId(poll.getId());
        pollDto.setUserId(poll.getUser().getId());
        pollDto.setTopic(poll.getTopic());

        //pollDto.setAnswers(poll.getAnswers());
        return pollDto;
    }

    public static Set<Poll> toSetEntity(Set<PollDTO> pollDtos){
        Set<Poll> polls = new HashSet<>();
        Iterator<PollDTO> it = pollDtos.iterator();
        while(it.hasNext()){
            Poll poll = PollMapper.toEntity(it.next());
            polls.add(poll);
        }
        return polls;
    }

    public static Set<PollDTO> toSetDto(Set<Poll> polls){
        Set<PollDTO> pollDtos = new HashSet<>();
        Iterator<Poll> it = polls.iterator();
        while(it.hasNext()){
            PollDTO poll = PollMapper.toDto(it.next());
            pollDtos.add(poll);
        }
        return pollDtos;

    }
}
