package com.example.engineer.services;

import com.example.engineer.entity.Result;
import com.example.engineer.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ResultService {
    @Autowired
    ResultRepository resultRepository;
    public Result CreateNewResult(String resultText,String resultType)
    {
        Result result = new Result();
        result.setDescription(resultText);
        result.setResultType(resultType);
        resultRepository.save(result);
        return result;
    }
}
