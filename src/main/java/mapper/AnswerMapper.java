package mapper;

import com.ibm.ro.tm.apprenticeship.poll.metter.dto.AnswerDTO;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Answer;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.Poll;
import com.ibm.ro.tm.apprenticeship.poll.metter.entity.User;
import com.ibm.ro.tm.apprenticeship.poll.metter.exception.CustomException;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.PollRepository;
import com.ibm.ro.tm.apprenticeship.poll.metter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import java.util.*;

@Configuration
public class AnswerMapper {

    private static  UserRepository userRepo;
    private static PollRepository pollRepo;

    @Autowired
    public AnswerMapper(UserRepository userRepo,PollRepository pollRepo) {
        this.userRepo = userRepo;
        this.pollRepo = pollRepo;
    }

    public static Answer toEntity(AnswerDTO answerDto){
        Answer answer = new Answer();

        Optional<User> existingUser = userRepo.findById(answerDto.getUserId());
        if (!existingUser.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+answerDto.getUserId()+" not found");
        }
        User userEntity = existingUser.get();

        Optional<Poll> existingPoll = pollRepo.findPollById(answerDto.getPollId());
        if (!existingPoll.isPresent()) {
            throw new CustomException(HttpStatus.NOT_FOUND,"User with id: "+answerDto.getPollId()+" not found");
        }
        Poll pollEntity = existingPoll.get();

        answer.setRating(answerDto.getRating());
        answer.setContent(answerDto.getContent());
        answer.setUser(userEntity);
        answer.setPoll(pollEntity);
        return answer;
    }

    public static AnswerDTO toDto(Answer answer){
        AnswerDTO answerDto = new AnswerDTO();
        answerDto.setId(answer.getId());
        answerDto.setContent(answer.getContent());
        answerDto.setRating(answer.getRating());
        answerDto.setUserId(answer.getUser().getId());
        answerDto.setPollId(answer.getPoll().getId());
        return answerDto;
    }

    public static Set<Answer> toSetEntity(Set<AnswerDTO> answerDtos){
        Set<Answer> answers = new HashSet<>();
        Iterator<AnswerDTO> it = answerDtos.iterator();
        while(it.hasNext()){
            Answer answer = AnswerMapper.toEntity(it.next());
            answers.add(answer);
        }
        return answers;
    }

    public static Set<AnswerDTO> toSetDto(Set<Answer> answers){
        Set<AnswerDTO> answerDtos = new HashSet<>();
        Iterator<Answer> it = answers.iterator();
        while(it.hasNext()){
            AnswerDTO answer = AnswerMapper.toDto(it.next());
            answerDtos.add(answer);
        }
        return answerDtos;

    }
}
