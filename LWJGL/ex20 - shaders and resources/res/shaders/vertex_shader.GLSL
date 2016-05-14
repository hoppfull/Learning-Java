#version 330 //OpenGL version used

layout (location = 0) in vec3 position;

//Variable 'color' is made available outside this shaders
out vec3 color;

void main(){

	color = vec3 ( clamp(position, 0.0, 1.0) ); //Clamp limit value between 0.0 and 1.0
	gl_Position = vec4(0.75 * position, 1.0);
}



