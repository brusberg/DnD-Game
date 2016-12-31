package com.brendenbrusberg.graphics;

import static org.lwjgl.glfw.GLFW.*;

//import org.lwjgl.glfw.GLFW;

import com.brendenbrusberg.Main;
import com.brendenbrusberg.graphics.Shader;
import com.brendenbrusberg.graphics.Texture;
import com.brendenbrusberg.graphics.VertexArray;
import com.brendenbrusberg.input.Input;
import com.brendenbrusberg.math.Matrix4f;
import com.brendenbrusberg.math.Vector3f;

public class Image {
	
	private Vector3f posistion = new Vector3f();
	private Matrix4f ml_matrix;
	
	private static float width, height;
	private String texturePath;
	private static Texture texture;
	private static VertexArray mesh;
	
	public void create(){
		
		float[]vertices = new float[]{
			//x, y, z
				0.0f,  0.0f, 0.1f,
				0.0f, height, 0.1f,
				width, height, 0.1f,
				width,  0.0f, 0.1f,
				 
		};
		//Basically everything in gaming is made out of triangles, so indices stops from repeating vertices because their will be matching vertices with 2 triangles making 1 rectangle
		byte[] indicies = new byte[]{
				0, 1, 2,
				2, 3, 0
				//The triangles made^ with the vertices above
		};
		
		float[] tcs = new float[]{
				//Texture Coordinates of the vertices above
				0, 1,//For vertices 0
				0, 0,//For vertices 1
				1, 0,//For vertices 2
				1, 1 //For vertices 3
		};
		
		//Takes the values above passed into VertexArray class to create an openGL object for the texture
		mesh = new VertexArray(vertices, indicies, tcs);
		texture = new Texture(texturePath);
	}
	
	public Image(float x, float y){
		posistion.x = x;
		posistion.y = y;
		ml_matrix = Matrix4f.translate(posistion);
	}
	
	public String getTexturePath(){
		return texturePath;
	}
	
	public void setTeturePath(String texturePath){
		this.texturePath=texturePath;
	}
	public float getX(){
		return posistion.x;
	}
	
	public float getY(){
		return posistion.y;
	}
	
	public Matrix4f getModelMatrix(){
		return ml_matrix;
	}
	
	public static VertexArray getMesh(){
		return mesh;
	}
	
	public static Texture getTexture(){
		return texture;
	}
	
	public static float getWidth(){
		return width;
	}
	
	public static float getHeight(){
		return height;
	}

}
