package com.example.TestTaskSovkombank.controller;

import com.example.TestTaskSovkombank.exception.ImageException;
import com.example.TestTaskSovkombank.service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/image")
@RequiredArgsConstructor
@CrossOrigin("*")
@Tag(
        name = "image endpoints",
        description = "u now, for images"
)
@ApiResponses(
        {
                @ApiResponse(
                        responseCode = "200",
                        description = "all ok"
                ),
                @ApiResponse(
                        responseCode = "500",
                        description = "internal error"
                )
        }
)
public class ImageController
{
    private final ImageService imageService;
    @GetMapping("/get")
    @Operation(
            summary = "Get image url based on query",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "contain image url",
                    content = @Content(
                            mediaType = "text/plain"
                    )
            )
    )
    public String getImage(@RequestParam String query) throws ImageException
    {
        return imageService.GetImage(query);
    }
}
