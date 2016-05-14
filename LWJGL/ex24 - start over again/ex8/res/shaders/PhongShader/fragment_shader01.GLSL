#version 330 //OpenGL version used

in vec2 tex_coord0;
in vec3 norm_coord0;

uniform sampler2D sampler;
uniform vec3 color_diffuse;
uniform vec3 light_ambient;

struct BaseLight
{
	vec3 color;
	float intensity;
};

struct DirectionalLight
{
	BaseLight base;
	vec3 direction;
};

vec4 calcLight(BaseLight base, vec3 direction, vec3 normal)
{
	float diffuseFactor = dot(-direction, normal);
	vec4 diffuseColor = vec4(0.0 , 0.0 , 0.0 , 0.0);
	
	if(diffuseFactor > 0)
	{
		diffuseColor = vec4(base.color, 1.0) * base.intensity * diffuseFactor;
	}
	
	return diffuseColor;
}

vec4 calcDirectionalLight(DirectionalLight directionalLight, vec3 normal)
{
	return calcLight(directionalLight.base, directionalLight.direction, normal);
}

void main()
{
	vec4 light_total = vec4(light_ambient, 1);
	vec4 color = vec4(color_diffuse, 1);
	vec4 tex = texture(sampler, tex_coord0.xy);
	
	gl_FragColor = color * light_total;
}