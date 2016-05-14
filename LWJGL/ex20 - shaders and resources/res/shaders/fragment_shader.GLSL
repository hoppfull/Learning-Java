#version 330 //OpenGL version used

out vec4 fragColor;

//Variable 'color' outside this shader is made available inside this shader
in vec3 color;

void main(){

	fragColor = vec4(color, 0.0);

}