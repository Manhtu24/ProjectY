package com.MTlovec.SharedOf.service;

import com.MTlovec.SharedOf.dto.common.BaseResponse;
import com.MTlovec.SharedOf.dto.request.UserDTO;
import com.MTlovec.SharedOf.dto.response.UserResponseDTO;

public interface AuthService {
    BaseResponse<UserResponseDTO> login(UserDTO userDTO);
}
