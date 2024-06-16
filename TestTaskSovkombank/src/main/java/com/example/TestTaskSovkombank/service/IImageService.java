package com.example.TestTaskSovkombank.service;

import com.example.TestTaskSovkombank.exception.ImageException;

public interface IImageService
{
    String GetImage(String _query) throws ImageException;
}
