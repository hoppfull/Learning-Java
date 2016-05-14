#version 330 //OpenGL version used

layout (location = 0) in vec3 position;

uniform float scale;
out vec3 color;

void main()
{
	color = vec3(clamp(position, 0.0, 1.0));
	gl_Position = vec4(scale * position, 1.0);
}