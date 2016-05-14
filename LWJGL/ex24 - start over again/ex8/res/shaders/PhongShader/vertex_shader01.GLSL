#version 330 //OpenGL version used


/* These variables take information in the attribpointerarray we created. Amazing!
Name these anything ya like!*/
layout (location = 0) in vec3 position;
layout (location = 1) in vec2 texture_coordinate;
layout (location = 2) in vec3 normal_coordinate;

out vec2 tex_coord0;
out vec3 norm_coord0;

uniform mat4 transform;

void main()
{
	gl_Position = transform * vec4(position, 1.0);
	tex_coord0 = texture_coordinate;
	norm_coord0 = normal_coordinate;
}