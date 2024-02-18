package by.ivuts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateAndUpdateDto {

    private String username;
    private String password;
    private List<Long> roleIds;

}
