package com.example.engineer.services;

import com.example.engineer.entity.Error;
import com.example.engineer.repository.ErrorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ErrorService {
    @Autowired
    ErrorRepository errorRepository;
    public Error CreateNewError(String description)
    {
        Error error = new Error();
        error.setDescription(description);
        errorRepository.save(error);
        return error;
    }
}
