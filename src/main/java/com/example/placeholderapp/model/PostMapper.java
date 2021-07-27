package com.example.placeholderapp.model;

import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@org.mapstruct.Mapper(componentModel = "spring")
public interface PostMapper
{
    @Mapping(target = "edited", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    void update(Post newPostVersion, @MappingTarget Post oldPostVersion);

    Post toModel(PostDTO postDto);

    List<Post> toModel(List<PostDTO> postDtos);

    List<PostDTO> toDtos(List<Post> post);
}
