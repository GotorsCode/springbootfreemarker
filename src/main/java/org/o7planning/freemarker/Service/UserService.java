package org.o7planning.freemarker.Service;

import org.o7planning.freemarker.Dto.UserDto;
import org.o7planning.freemarker.model.UserEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static Map<Long, UserEntity> users = new HashMap<>();

    private Long id = 1L;

    public Long createUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity(userDto);
        userEntity.setId(id);
        users.put(id, userEntity);
        id++;
        return userEntity.getId();
    }

    public UserDto getUser(Long userId) throws Exception {

        UserEntity userEntity = (users.get(userId).getDeleted()) ? null : users.get(userId);

        if (userEntity == null) {
            throw new Exception();
        }

        return new UserDto(userEntity);
    }

    public void deleteUser(Long userId) {
        UserEntity userEntity = users.get(userId);
        if (userEntity != null) {
            userEntity.setDeleted(true);
        }
    }

    public void modifyUser(Long userId, UserDto userDto) {
        if ((userId != null) && (userId <= id)) {
            UserEntity userEntity = users.get(userId);
            if (userEntity != null) {
                if (StringUtils.hasText(userDto.getFirstName())) {
                    userEntity.setFirstName(userDto.getFirstName());
                }

                if (StringUtils.hasText(userDto.getLastName())) {
                    userEntity.setLastName(userDto.getLastName());
                }
            }
        }
    }

}
