package co.uk.silvania.Remula.dimensions.akatoe;

import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.CAVE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.MINESHAFT;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.RAVINE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.SCATTERED_FEATURE;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.STRONGHOLD;
import static net.minecraftforge.event.terraingen.InitMapGenEvent.EventType.VILLAGE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;

import java.util.List;
import java.util.Random;

import co.uk.silvania.Remula.Remula;
import co.uk.silvania.Remula.RemulaBlocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.MapGenBase;
import net.minecraft.world.gen.MapGenCaves;
import net.minecraft.world.gen.MapGenRavine;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.MapGenScatteredFeature;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.structure.MapGenMineshaft;
import net.minecraft.world.gen.structure.MapGenStronghold;
import net.minecraft.world.gen.structure.MapGenVillage;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.Event.Result;
import net.minecraftforge.event.terraingen.ChunkProviderEvent;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class AkatoeChunkProvider implements IChunkProvider {

	private Random rand;
	private NoiseGeneratorOctaves noiseGen1;
	private NoiseGeneratorOctaves noiseGen2;
	private NoiseGeneratorOctaves noiseGen3;
	private NoiseGeneratorOctaves noiseGen4;
	public NoiseGeneratorOctaves noiseGen5;
	public NoiseGeneratorOctaves noiseGen6;
	public NoiseGeneratorOctaves mobSpawnerNoise;
	private World worldObj;
	private final boolean mapFeaturesEnabled;
	private double[] noiseArray;
	private double[] stoneNoise = new double[256];
	private MapGenBase caveGenerator = new MapGenCaves();
	private MapGenStronghold strongholdGenerator = new MapGenStronghold();
	private MapGenVillage villageGenerator = new MapGenVillage();
	private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
	private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
	private MapGenBase ravineGenerator = new MapGenRavine();
	private BiomeGenBase[] biomesForGeneration;
	double[] noise1;
	double[] noise2;
	double[] noise3;
	double[] noise5;
	double[] noise6;
	float[] parabolicField;
	int[][] field_73219_j = new int[32][32];
	{
		caveGenerator = TerrainGen.getModdedMapGen(caveGenerator, CAVE);
		strongholdGenerator = (MapGenStronghold) TerrainGen.getModdedMapGen(strongholdGenerator, STRONGHOLD);
		villageGenerator = (MapGenVillage) TerrainGen.getModdedMapGen(villageGenerator, VILLAGE);
		mineshaftGenerator = (MapGenMineshaft) TerrainGen.getModdedMapGen(mineshaftGenerator, MINESHAFT);
		scatteredFeatureGenerator = (MapGenScatteredFeature) TerrainGen.getModdedMapGen(scatteredFeatureGenerator, SCATTERED_FEATURE);
		ravineGenerator = TerrainGen.getModdedMapGen(ravineGenerator, RAVINE);
	}

	public AkatoeChunkProvider(World world, long seed, boolean mapFeaturesEnabled) {
		this.worldObj = world;
		this.mapFeaturesEnabled = mapFeaturesEnabled;
		this.rand = new Random(seed);
		this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
		this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
		this.noiseGen4 = new NoiseGeneratorOctaves(this.rand, 4);
		this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
		this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
		this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);

		NoiseGeneratorOctaves[] noiseGens = { noiseGen1, noiseGen2, noiseGen3, noiseGen4, noiseGen5, noiseGen6, mobSpawnerNoise };
		noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
		this.noiseGen1 = noiseGens[0];
		this.noiseGen2 = noiseGens[1];
		this.noiseGen3 = noiseGens[2];
		this.noiseGen4 = noiseGens[3];
		this.noiseGen5 = noiseGens[4];
		this.noiseGen6 = noiseGens[5];
		this.mobSpawnerNoise = noiseGens[6];
	}

	public void generateTerrain(int par1, int par2, byte[] par3ArrayOfByte) {
		byte b0 = 4;
		byte b1 = 16;
		byte b2 = 63;
		int k = b0 + 1;
		byte b3 = 17;
		int l = b0 + 1;
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().getBiomesForGeneration(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, k + 5, l + 5);
		this.noiseArray = this.initializeNoiseField(this.noiseArray, par1 * b0, 0, par2 * b0, k, b3, l);

		for (int i1 = 0; i1 < b0; ++i1) {
			for (int j1 = 0; j1 < b0; ++j1) {
				for (int k1 = 0; k1 < b1; ++k1) {
					double d0 = 0.125D;
					double d1 = this.noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 0];
					double d2 = this.noiseArray[((i1 + 0) * l + j1 + 1) * b3 + k1 + 0];
					double d3 = this.noiseArray[((i1 + 1) * l + j1 + 0) * b3 + k1 + 0];
					double d4 = this.noiseArray[((i1 + 1) * l + j1 + 1) * b3 + k1 + 0];
					double d5 = (this.noiseArray[((i1 + 0) * l + j1 + 0) * b3 + k1 + 1] - d1) * d0;
					double d6 = (this.noiseArray[((i1 + 0) * l + j1 + 1) * b3 + k1 + 1] - d2) * d0;
					double d7 = (this.noiseArray[((i1 + 1) * l + j1 + 0) * b3 + k1 + 1] - d3) * d0;
					double d8 = (this.noiseArray[((i1 + 1) * l + j1 + 1) * b3 + k1 + 1] - d4) * d0;

					for (int l1 = 0; l1 < 8; ++l1) {
						double d9 = 0.25D;
						double d10 = d1;
						double d11 = d2;
						double d12 = (d3 - d1) * d9;
						double d13 = (d4 - d2) * d9;

						for (int i2 = 0; i2 < 4; ++i2) {
							int j2 = i2 + i1 * 4 << 11 | 0 + j1 * 4 << 7 | k1 * 8 + l1;
							short short1 = 128;
							j2 -= short1;
							double d14 = 0.25D;
							double d15 = (d11 - d10) * d14;
							double d16 = d10 - d15;

							for (int k2 = 0; k2 < 4; ++k2) {
								if ((d16 += d15) > 0.0D) {
									par3ArrayOfByte[j2 += short1] = (byte) RemulaBlocks.akatoeStone.blockID;//Block.stone.blockID;
								} else if (k1 * 8 + l1 < b2) {
									par3ArrayOfByte[j2 += short1] = (byte) Block.waterStill.blockID;
								} else {
									par3ArrayOfByte[j2 += short1] = 0;
								}
							}

							d10 += d12;
							d11 += d13;
						}

						d1 += d5;
						d2 += d6;
						d3 += d7;
						d4 += d8;
					}
				}
			}
		}
	}

	public void replaceBlocksForBiome(int par1, int par2, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase) {
		byte var5 = 63;
		double var6 = 0.03125D;
		this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, par1 * 16, par2 * 16, 0, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);
		for (int var8 = 0; var8 < 16; var8++) {
			for (int var9 = 0; var9 < 16; var9++) {
				BiomeGenBase var10 = par4ArrayOfBiomeGenBase[(var9 + var8 * 16)];
				float var11 = var10.getFloatTemperature();
				int var12 = (int)(this.stoneNoise[(var8 + var9 * 16)] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
				int var13 = -1;
				byte var14 = var10.topBlock;
				byte var15 = var10.fillerBlock;
				for (int var16 = 127; var16 >= 0; var16--) {
					int var17 = (var9 * 16 + var8) * 128 + var16;
					if (var16 <= 0 + this.rand.nextInt(5)) {
						par3ArrayOfByte[var17] = ((byte)Block.bedrock.blockID);
					} else {
						byte var18 = par3ArrayOfByte[var17];
						if (var18 == 0) {
							var13 = -1;
						}
						//TODO Stone
						else if (var18 != RemulaBlocks.akatoeStone.blockID) {
							if (var13 == -1) {
								if (var12 == 0) {
									var14 = 0;

									//TODO Dirt
									var15 = (byte)RemulaBlocks.akatoeDirt.blockID;
								}
								else if ((var16 >= var5 - 4) && (var16 <= var5 + 1)) {
									var14 = var10.topBlock;
									var15 = var10.fillerBlock;
								}
								if ((var16 < var5) && (var14 == 0)) {
									if (var11 < 0.15F) {
										var14 = (byte)Block.ice.blockID;
									} else {
										var14 = (byte)Block.waterStill.blockID;
									}
								}
								var13 = var12;
								if (var16 >= var5 - 1) {
									par3ArrayOfByte[var17] = var14;
								} else {
									par3ArrayOfByte[var17] = var15;
								}
							}
							else if (var13 > 0) {
								var13--;
								par3ArrayOfByte[var17] = var15;
								if ((var13 == 0) && (var15 == Block.sand.blockID)) {
									var13 = this.rand.nextInt(4);
									var15 = (byte)Block.sandStone.blockID;
								}
							}
						}
					}
				}
			}
		}
	}

	/**
	 * loads or generates the chunk at the chunk location specified
	 */
	public Chunk loadChunk(int par1, int par2) {
		return this.provideChunk(par1, par2);
	}

	/**
	 * Will return back a chunk, if it doesn't exist and its not a MP client it
	 * will generates all the blocks for the specified chunk from the map seed
	 * and chunk seed
	 */
	public Chunk provideChunk(int par1, int par2) {
		this.rand.setSeed((long) par1 * 341873128712L + (long) par2 * 132897987541L);
		byte[] abyte = new byte[32768];
		this.generateTerrain(par1, par2, abyte);
		this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
		this.replaceBlocksForBiome(par1, par2, abyte, this.biomesForGeneration);
		this.caveGenerator.generate(this, this.worldObj, par1, par2, abyte);
		this.ravineGenerator.generate(this, this.worldObj, par1, par2, abyte);

		if (this.mapFeaturesEnabled) {
			this.mineshaftGenerator.generate(this, this.worldObj, par1, par2, abyte);
			this.villageGenerator.generate(this, this.worldObj, par1, par2, abyte);
			this.strongholdGenerator.generate(this, this.worldObj, par1, par2, abyte);
			this.scatteredFeatureGenerator.generate(this, this.worldObj, par1, par2, abyte);
		}

		Chunk chunk = new Chunk(this.worldObj, abyte, par1, par2);
		byte[] abyte1 = chunk.getBiomeArray();

		for (int k = 0; k < abyte1.length; ++k) {
			abyte1[k] = (byte) this.biomesForGeneration[k].biomeID;
		}

		chunk.generateSkylightMap();
		return chunk;
	}

	/**
	 * generates a subset of the level's terrain data. Takes 7 arguments: the
	 * [empty] noise array, the position, and the size.
	 */
	private double[] initializeNoiseField(double[] par1ArrayOfDouble, int par2, int par3, int par4, int par5, int par6, int par7) {
		ChunkProviderEvent.InitNoiseField event = new ChunkProviderEvent.InitNoiseField(this, par1ArrayOfDouble, par2, par3, par4, par5, par6, par7);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.getResult() == Result.DENY)
			return event.noisefield;

		if (par1ArrayOfDouble == null) {
			par1ArrayOfDouble = new double[par5 * par6 * par7];
		}

		if (this.parabolicField == null) {
			this.parabolicField = new float[25];

			for (int k1 = -2; k1 <= 2; ++k1) {
				for (int l1 = -2; l1 <= 2; ++l1) {
					float f = 10.0F / MathHelper.sqrt_float((float) (k1 * k1 + l1 * l1) + 0.2F);
					this.parabolicField[k1 + 2 + (l1 + 2) * 5] = f;
				}
			}
		}

		double d0 = 684.412D;
		double d1 = 684.412D;
		this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, par2, par4, par5, par7, 1.121D, 1.121D, 0.5D);
		this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, par2, par4, par5, par7, 200.0D, 200.0D, 0.5D);
		this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, par2, par3, par4, par5, par6, par7, d0 / 80.0D, d1 / 160.0D, d0 / 80.0D);
		this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, par2, par3, par4, par5, par6, par7, d0, d1, d0);
		this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, par2, par3, par4, par5, par6, par7, d0, d1, d0);
		boolean flag = false;
		boolean flag1 = false;
		int i2 = 0;
		int j2 = 0;

		for (int k2 = 0; k2 < par5; ++k2) {
			for (int l2 = 0; l2 < par7; ++l2) {
				float f1 = 0.0F;
				float f2 = 0.0F;
				float f3 = 0.0F;
				byte b0 = 2;
				BiomeGenBase biomegenbase = this.biomesForGeneration[k2 + 2 + (l2 + 2) * (par5 + 5)];

				for (int i3 = -b0; i3 <= b0; ++i3) {
					for (int j3 = -b0; j3 <= b0; ++j3) {
						BiomeGenBase biomegenbase1 = this.biomesForGeneration[k2 + i3 + 2 + (l2 + j3 + 2) * (par5 + 5)];
						float f4 = this.parabolicField[i3 + 2 + (j3 + 2) * 5] / (biomegenbase1.minHeight + 2.0F);

						if (biomegenbase1.minHeight > biomegenbase.minHeight) {
							f4 /= 2.0F;
						}

						f1 += biomegenbase1.maxHeight * f4;
						f2 += biomegenbase1.minHeight * f4;
						f3 += f4;
					}
				}

				f1 /= f3;
				f2 /= f3;
				f1 = f1 * 0.9F + 0.1F;
				f2 = (f2 * 4.0F - 1.0F) / 8.0F;
				double d2 = this.noise6[j2] / 8000.0D;

				if (d2 < 0.0D) {
					d2 = -d2 * 0.3D;
				}

				d2 = d2 * 3.0D - 2.0D;

				if (d2 < 0.0D) {
					d2 /= 2.0D;

					if (d2 < -1.0D) {
						d2 = -1.0D;
					}

					d2 /= 1.4D;
					d2 /= 2.0D;
				} else {
					if (d2 > 1.0D) {
						d2 = 1.0D;
					}

					d2 /= 8.0D;
				}

				++j2;

				for (int k3 = 0; k3 < par6; ++k3) {
					double d3 = (double) f2;
					double d4 = (double) f1;
					d3 += d2 * 0.2D;
					d3 = d3 * (double) par6 / 16.0D;
					double d5 = (double) par6 / 2.0D + d3 * 4.0D;
					double d6 = 0.0D;
					double d7 = ((double) k3 - d5) * 12.0D * 128.0D / 128.0D / d4;

					if (d7 < 0.0D) {
						d7 *= 4.0D;
					}

					double d8 = this.noise1[i2] / 512.0D;
					double d9 = this.noise2[i2] / 512.0D;
					double d10 = (this.noise3[i2] / 10.0D + 1.0D) / 2.0D;

					if (d10 < 0.0D) {
						d6 = d8;
					} else if (d10 > 1.0D) {
						d6 = d9;
					} else {
						d6 = d8 + (d9 - d8) * d10;
					}

					d6 -= d7;

					if (k3 > par6 - 4) {
						double d11 = (double) ((float) (k3 - (par6 - 4)) / 3.0F);
						d6 = d6 * (1.0D - d11) + -10.0D * d11;
					}

					par1ArrayOfDouble[i2] = d6;
					++i2;
				}
			}
		}

		return par1ArrayOfDouble;
	}

	/**
	 * Checks to see if a chunk exists at x, y
	 */
	public boolean chunkExists(int par1, int par2) {
		return true;
	}

	/**
	 * Populates chunk with ores etc etc
	 */
	public void populate(IChunkProvider par1IChunkProvider, int par2, int par3) {
		BlockSand.fallInstantly = true;
		int k = par2 * 16;
		int l = par3 * 16;
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(k + 16, l + 16);
		this.rand.setSeed(this.worldObj.getSeed());
		long i1 = this.rand.nextLong() / 2L * 2L + 1L;
		long j1 = this.rand.nextLong() / 2L * 2L + 1L;
		this.rand.setSeed((long) par2 * i1 + (long) par3 * j1 ^ this.worldObj.getSeed());
		boolean flag = false;

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Pre(par1IChunkProvider, worldObj, rand, par2, par3, flag));

		if (this.mapFeaturesEnabled) {
			this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
			flag = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
			this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
			this.scatteredFeatureGenerator.generateStructuresInChunk(this.worldObj, this.rand, par2, par3);
		}

		int k1;
		int l1;
		int i2;

		if (TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, LAKE) && !flag && this.rand.nextInt(4) == 0) {
			k1 = k + this.rand.nextInt(16) + 8;
			l1 = this.rand.nextInt(128);
			i2 = l + this.rand.nextInt(16) + 8;
			(new WorldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.rand, k1, l1, i2);
		}

		boolean doGen = TerrainGen.populate(par1IChunkProvider, worldObj, rand, par2, par3, flag, DUNGEON);
		for (k1 = 0; doGen && k1 < 8; ++k1) {
			l1 = k + this.rand.nextInt(16) + 8;
			i2 = this.rand.nextInt(128);
			int j2 = l + this.rand.nextInt(16) + 8;

			if ((new WorldGenDungeons()).generate(this.worldObj, this.rand, l1, i2, j2)) {
				;
			}
		}

		//World Tree Generation
        for (int c = 60; c > 0; c--) {
                int j2 = k + rand.nextInt(16) + 8;
                int l3 = rand.nextInt(120);
                int j5 = l + rand.nextInt(16) + 8;
                if ((worldObj.getBlockId(j2, l3, j5) == 0) && (worldObj.getBlockId(j2, l3 - 1, j5) == RemulaBlocks.akatoeGrass.blockID)) {
                	new AkatoeGenTrees(true, 6 + rand.nextInt(8), 1, 1).generate(worldObj, rand, j2, l3, j5);
                }
        }
        for (int c = 50; c > 0; c--) {
                int j2 = k + rand.nextInt(16) + 8;
                int l3 = rand.nextInt(120);
                int j5 = l + rand.nextInt(16) + 8;
                if ((worldObj.getBlockId(j2, l3, j5) == 0) && (worldObj.getBlockId(j2, l3 - 1, j5) == RemulaBlocks.akatoeGrass.blockID)) {
                	new AkatoeGenTrees(true, 6 + rand.nextInt(8), 1, 1).generate(worldObj, rand, j2, l3, j5);
                }
        }
        for (int c = 50; c > 0; c--) {
                int j2 = k + rand.nextInt(16) + 8;
                int l3 = rand.nextInt(120);
                int j5 = l + rand.nextInt(16) + 8;
                if ((worldObj.getBlockId(j2, l3, j5) == 0) && (worldObj.getBlockId(j2, l3 - 1, j5) == RemulaBlocks.akatoeGrass.blockID)) {
                	new AkatoeGenTrees(true, 6 + rand.nextInt(8), 2, 2).generate(worldObj, rand, j2, l3, j5);
                }
        }
        for (int c = 50; c > 0; c--) {
                int j2 = k + rand.nextInt(16) + 8;
                int l3 = rand.nextInt(120);
                int j5 = l + rand.nextInt(16) + 8;
                if ((worldObj.getBlockId(j2, l3, j5) == 0) && (worldObj.getBlockId(j2, l3 - 1, j5) == RemulaBlocks.akatoeGrass.blockID)) {
                	new AkatoeGenTrees(true, 6 + rand.nextInt(8), 3, 3).generate(worldObj, rand, j2, l3, j5);
                }
        }
        for (int c = 50; c > 0; c--) {
                int j2 = k + rand.nextInt(16) + 8;
                int l3 = rand.nextInt(120);
                int j5 = l + rand.nextInt(16) + 8;
                if ((worldObj.getBlockId(j2, l3, j5) == 0) && (worldObj.getBlockId(j2, l3 - 1, j5) == RemulaBlocks.akatoeGrass.blockID)) {
                	new AkatoeGenTrees(true, 6 + rand.nextInt(8), 0, 0).generate(worldObj, rand, j2, l3, j5);
                }
        }
        for (int c = 60; c > 0; c--) {
                int j2 = k + rand.nextInt(16) + 8;
                int l3 = rand.nextInt(120);
                int j5 = l + rand.nextInt(16) + 8;
                if ((worldObj.getBlockId(j2, l3, j5) == 0) && (worldObj.getBlockId(j2, l3 - 1, j5) == RemulaBlocks.akatoeGrass.blockID)) {
                	new AkatoeGenTrees(true, 6 + rand.nextInt(8), 0, 0).generate(worldObj, rand, j2, l3, j5);
                }
        }
        //Forest Trees
        for (int c = 60; c > 0; c--) {
                int j2 = k + rand.nextInt(16) + 8;
                int l3 = rand.nextInt(120);
                int j5 = l + rand.nextInt(16) + 8;
                if ((worldObj.getBlockId(j2, l3, j5) == 0) && (worldObj.getBlockId(j2, l3 - 1, j5) == RemulaBlocks.akatoeGrass.blockID)) {
                	new AkatoeGenForestTree(true).generate(worldObj, rand, j2, l3, j5);
                }
        }
        
        //Huge Trees
        for (int c = 60; c > 0; c--) {
                int j2 = k + rand.nextInt(16) + 8;
                int l3 = rand.nextInt(120);
                int j5 = l + rand.nextInt(16) + 8;
                if ((worldObj.getBlockId(j2, l3, j5) == 0) && (worldObj.getBlockId(j2, l3 - 1, j5) == RemulaBlocks.akatoeGrass.blockID)) {
                	new AkatoeGenHugeTree(true, 15 + rand.nextInt(8), 0, 0).generate(worldObj, rand, j2, l3, j5);
                }
        }

		MinecraftForge.EVENT_BUS.post(new PopulateChunkEvent.Post(par1IChunkProvider, worldObj, rand, par2, par3, flag));
		BlockSand.fallInstantly = false;
	}

	public boolean saveChunks(boolean par1, IProgressUpdate par2IProgressUpdate) {
		return true;
	}

	public boolean unloadQueuedChunks() {
		return false;
	}

	public boolean canSave() {
		return true;
	}

	public String makeString() {
		return "RandomLevelSource";
	}

	public List getPossibleCreatures(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
		BiomeGenBase biomegenbase = this.worldObj.getBiomeGenForCoords(par2, par4);
		return biomegenbase == null ? null : (biomegenbase == BiomeGenBase.swampland && par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.hasStructureAt(par2, par3, par4) ? this.scatteredFeatureGenerator.getScatteredFeatureSpawnList() : biomegenbase.getSpawnableList(par1EnumCreatureType));
	}

	public ChunkPosition findClosestStructure(World par1World, String par2Str, int par3, int par4, int par5) {
		return "Stronghold".equals(par2Str) && this.strongholdGenerator != null ? this.strongholdGenerator.getNearestInstance(par1World, par3, par4, par5) : null;
	}

	public int getLoadedChunkCount() {
		return 0;
	}

	public void recreateStructures(int par1, int par2) {
		if (this.mapFeaturesEnabled) {
			this.mineshaftGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.villageGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.strongholdGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
			this.scatteredFeatureGenerator.generate(this, this.worldObj, par1, par2, (byte[]) null);
		}
	}

	@Override
	public void saveExtraData() {
		// TODO Auto-generated method stub
		
	}
}