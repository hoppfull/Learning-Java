#version 330 //OpenGL version used

layout (location = 0) in vec3 position;

out vec3 color;
uniform mat4 transform;

void main()
{
	color = vec3(clamp(position, 0.0, 1.0));
	gl_Position = transform * vec4(0.5 * position, 1.0);
}