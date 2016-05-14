#version 330 //OpenGL version used

out vec4 fragColor;

in vec3 color;

void main()
{
	fragColor = vec4(color, 0.0);
}