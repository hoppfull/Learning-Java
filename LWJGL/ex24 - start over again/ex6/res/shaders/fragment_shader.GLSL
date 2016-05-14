#version 330 //OpenGL version used

in vec2 tex_coord0;

uniform sampler2D sampler;

void main()
{
	gl_FragColor = texture2D(sampler, tex_coord0.xy);
}