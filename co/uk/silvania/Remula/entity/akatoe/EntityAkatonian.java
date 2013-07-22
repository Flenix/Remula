/*package co.uk.silvania.Remula.entity.akatoe;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import co.uk.silvania.Remula.Remula;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.INpc;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIFollowGolem;
import net.minecraft.entity.ai.EntityAILookAtTradePlayer;
import net.minecraft.entity.ai.EntityAIMoveIndoors;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIOpenDoor;
import net.minecraft.entity.ai.EntityAIPlay;
import net.minecraft.entity.ai.EntityAIRestrictOpenDoor;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITradePlayer;
import net.minecraft.entity.ai.EntityAIVillagerMate;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityAIWatchClosest2;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Tuple;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraft.village.Village;
import net.minecraft.world.World;

public class EntityAkatonian extends EntityAgeable implements INpc, IMerchant
{
    private int randomTickDivider;
    private boolean isMating;
    private boolean isPlaying;
    Village villageObj;

    private EntityPlayer buyingPlayer;

    private MerchantRecipeList buyingList;
    private int timeUntilReset;

    private boolean needsInitilization;
    private int wealth;

    private String lastBuyingPlayer;
    private boolean field_82190_bM;
    private float field_82191_bN;

    public static final Map villagerStockList = new HashMap();
    
    public static final ResourceLocation mobAkatonian = new ResourceLocation("remula", "textures/entities/mobakatonian.png");
    public static final ResourceLocation mobAkatonianFarmer = new ResourceLocation("remula", "textures/entities/mobakatonianfarmer.png");

    public static final Map blacksmithSellingList = new HashMap();

    public EntityAkatonian(World par1World)
    {
        this(par1World, 0);
    }

    public EntityAkatonian(World par1World, int par2)
    {
        super(par1World);
        this.randomTickDivider = 0;
        this.isMating = false;
        this.isPlaying = false;
        this.villageObj = null;
        this.setProfession(par2);
        this.getNavigator().setBreakDoors(true);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.3F, 0.35F));
        this.tasks.addTask(1, new AkatoeTradePlayer(this));
        this.tasks.addTask(1, new AkatoeLookAtTradePlayer(this));
        this.tasks.addTask(2, new EntityAIMoveIndoors(this));
        this.tasks.addTask(3, new EntityAIRestrictOpenDoor(this));
        this.tasks.addTask(4, new EntityAIOpenDoor(this, true));
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.3F));
        this.tasks.addTask(6, new AkatoeMate(this));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityPlayer.class, 3.0F, 1.0F));
        this.tasks.addTask(9, new EntityAIWatchClosest2(this, EntityAkatonian.class, 5.0F, 0.02F));
        this.tasks.addTask(9, new EntityAIWander(this, 0.3F));
        this.tasks.addTask(10, new EntityAIWatchClosest(this, EntityLiving.class, 8.0F));
    }

    public boolean isAIEnabled()
    {
        return true;
    }

    protected void updateAITick()
    {
        if (--this.randomTickDivider <= 0)
        {
            this.worldObj.villageCollectionObj.addVillagerPosition(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ));
            this.randomTickDivider = 70 + this.rand.nextInt(50);
            this.villageObj = this.worldObj.villageCollectionObj.findNearestVillage(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY), MathHelper.floor_double(this.posZ), 32);

            if (this.villageObj == null)
            {
                this.detachHome();
            }
            else
            {
                ChunkCoordinates var1 = this.villageObj.getCenter();
                this.setHomeArea(var1.posX, var1.posY, var1.posZ, (int)((float)this.villageObj.getVillageRadius() * 0.6F));

                if (this.field_82190_bM)
                {
                    this.field_82190_bM = false;
                    this.villageObj.func_82683_b(5);
                }
            }
        }

        if (!this.isTrading() && this.timeUntilReset > 0)
        {
            --this.timeUntilReset;

            if (this.timeUntilReset <= 0)
            {
                if (this.needsInitilization)
                {
                    if (this.buyingList.size() > 1)
                    {
                        Iterator var3 = this.buyingList.iterator();

                        while (var3.hasNext())
                        {
                            MerchantRecipe var2 = (MerchantRecipe)var3.next();

                            if (var2.func_82784_g())
                            {
                                var2.func_82783_a(this.rand.nextInt(6) + this.rand.nextInt(6) + 2);
                            }
                        }
                    }

                    this.addDefaultEquipmentAndRecipies(1);
                    this.needsInitilization = false;

                    if (this.villageObj != null && this.lastBuyingPlayer != null)
                    {
                        this.worldObj.setEntityState(this, (byte)14);
                        this.villageObj.setReputationForPlayer(this.lastBuyingPlayer, 1);
                    }
                }

                this.addPotionEffect(new PotionEffect(Potion.regeneration.id, 200, 0));
            }
        }

        super.updateAITick();
    }

    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();
        boolean var3 = var2 != null && var2.itemID == Item.monsterPlacer.itemID;

        if (!var3 && this.isEntityAlive() && !this.isTrading() && !this.isChild())
        {
            if (!this.worldObj.isRemote)
            {
                this.setCustomer(par1EntityPlayer);
                par1EntityPlayer.displayGUIMerchant(this, lastBuyingPlayer);
            }

            return true;
        }
        else
        {
            return super.interact(par1EntityPlayer);
        }
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, Integer.valueOf(0));
    }

    public int getMaxHealth()
    {
        return 20;
    }

    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("Profession", this.getProfession());
        par1NBTTagCompound.setInteger("Riches", this.wealth);

        if (this.buyingList != null)
        {
            par1NBTTagCompound.setCompoundTag("Offers", this.buyingList.getRecipiesAsTags());
        }
    }

    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setProfession(par1NBTTagCompound.getInteger("Profession"));
        this.wealth = par1NBTTagCompound.getInteger("Riches");

        if (par1NBTTagCompound.hasKey("Offers"))
        {
            NBTTagCompound var2 = par1NBTTagCompound.getCompoundTag("Offers");
            this.buyingList = new MerchantRecipeList(var2);
        }
    }

    @SideOnly(Side.CLIENT)
    public String getTexture()
    {
        switch (this.getProfession())
        {
            case 0:
                return mobAkatonianFarmer;
            case 1:
                return "/co/uk/silvania/Remula/resources/mobakatonianlibrarian.png";
            case 2:
                return "/co/uk/silvania/Remula/resources/mobakatonianpriest.png";
            case 3:
                return "/co/uk/silvania/Remula/resources/mobakatoniansmith.png";
            case 4:
                return "/co/uk/silvania/Remula/resources/mobakatonianbutcher.png";
            default:
                return AkatoeVillagerRegistry.getVillagerSkin(this.getProfession(), super.getTexture());
        }
    }

    protected boolean canDespawn()
    {
        return false;
    }

    protected String getLivingSound()
    {
        return "mob.villager.default";
    }

    protected String getHurtSound()
    {
        return "mob.villager.defaulthurt";
    }

    protected String getDeathSound()
    {
        return "mob.villager.defaultdeath";
    }

    public void setProfession(int par1)
    {
        this.dataWatcher.updateObject(16, Integer.valueOf(par1));
    }

    public int getProfession()
    {
        return this.dataWatcher.getWatchableObjectInt(16);
    }

    public boolean isMating()
    {
        return this.isMating;
    }

    public void setMating(boolean par1)
    {
        this.isMating = par1;
    }

    public void setPlaying(boolean par1)
    {
        this.isPlaying = par1;
    }

    public boolean isPlaying()
    {
        return this.isPlaying;
    }

    public void setRevengeTarget(EntityLiving par1EntityLiving)
    {
        super.setRevengeTarget(par1EntityLiving);

        if (this.villageObj != null && par1EntityLiving != null)
        {
            this.villageObj.addOrRenewAgressor(par1EntityLiving);

            if (par1EntityLiving instanceof EntityPlayer)
            {
                byte var2 = -1;

                if (this.isChild())
                {
                    var2 = -3;
                }

                this.villageObj.setReputationForPlayer(((EntityPlayer)par1EntityLiving).getCommandSenderName(), var2);

                if (this.isEntityAlive())
                {
                    this.worldObj.setEntityState(this, (byte)13);
                }
            }
        }
    }

    public void onDeath(DamageSource par1DamageSource)
    {
        if (this.villageObj != null)
        {
            Entity var2 = par1DamageSource.getEntity();

            if (var2 != null)
            {
                if (var2 instanceof EntityPlayer)
                {
                    this.villageObj.setReputationForPlayer(((EntityPlayer)var2).getCommandSenderName(), -2);
                }
                else if (var2 instanceof IMob)
                {
                    this.villageObj.endMatingSeason();
                }
            }
            else if (var2 == null)
            {
                EntityPlayer var3 = this.worldObj.getClosestPlayerToEntity(this, 16.0D);

                if (var3 != null)
                {
                    this.villageObj.endMatingSeason();
                }
            }
        }

        super.onDeath(par1DamageSource);
    }

    public void setCustomer(EntityPlayer par1EntityPlayer)
    {
        this.buyingPlayer = par1EntityPlayer;
    }

    public EntityPlayer getCustomer()
    {
        return this.buyingPlayer;
    }

    public boolean isTrading()
    {
        return this.buyingPlayer != null;
    }

    public void useRecipe(MerchantRecipe par1MerchantRecipe)
    {
        par1MerchantRecipe.incrementToolUses();

        if (par1MerchantRecipe.hasSameIDsAs((MerchantRecipe)this.buyingList.get(this.buyingList.size() - 1)))
        {
            this.timeUntilReset = 40;
            this.needsInitilization = true;

            if (this.buyingPlayer != null)
            {
                this.lastBuyingPlayer = this.buyingPlayer.getCommandSenderName();
            }
            else
            {
                this.lastBuyingPlayer = null;
            }
        }

        if (par1MerchantRecipe.getItemToBuy().itemID == Item.emerald.itemID)
        {
            this.wealth += par1MerchantRecipe.getItemToBuy().stackSize;
        }
    }

    public MerchantRecipeList getRecipes(EntityPlayer par1EntityPlayer)
    {
        if (this.buyingList == null)
        {
            this.addDefaultEquipmentAndRecipies(1);
        }

        return this.buyingList;
    }

    private float func_82188_j(float par1)
    {
        float var2 = par1 + this.field_82191_bN;
        return var2 > 0.9F ? 0.9F - (var2 - 0.9F) : var2;
    }

    private void addDefaultEquipmentAndRecipies(int par1)
    {
        if (this.buyingList != null)
        {
            this.field_82191_bN = MathHelper.sqrt_float((float)this.buyingList.size()) * 0.2F;
        }
        else
        {
            this.field_82191_bN = 0.0F;
        }

        MerchantRecipeList var2;
        var2 = new MerchantRecipeList();
        AkatoeVillagerRegistry.manageVillagerTrades(var2, this, this.getProfession(), this.rand);
        int var6;
        label50:

        switch (this.getProfession())
        {
            case 0:
                /*addMerchantItem(var2, Remula.porinFruit.itemID, this.rand, this.func_82188_j(0.9F));
                addMerchantItem(var2, Remula.porinSeeds.itemID, this.rand, this.func_82188_j(0.5F));
                addMerchantItem(var2, Remula.ulinFruit.itemID, this.rand, this.func_82188_j(0.5F));
                addMerchantItem(var2, Remula.ulinSeeds.itemID, this.rand, this.func_82188_j(0.4F));
                addBlacksmithItem(var2, Remula.itemCir.itemID, this.rand, this.func_82188_j(0.9F));
                addBlacksmithItem(var2, Remula.itemBoskin.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Remula.cirSeeds.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Remula.boskinSeeds.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Remula.rawGlogMeat.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Remula.cookedGlogMeat.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Remula.rawGarfinMeat.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Remula.cookedGarfinMeat.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Remula.rawHermustMeat.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Remula.cookedHermustMeat.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Remula.rawLignisMeat.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Remula.cookedLignisMeat.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Remula.skitterling.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Remula.skitterlingDead.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Remula.rawSkitterlingStick.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Remula.cookedSkitterlingStick.itemID, this.rand, this.func_82188_j(0.5F));

                if (this.rand.nextFloat() < this.func_82188_j(0.5F))
                {
                    var2.add(new MerchantRecipe(new ItemStack(Block.gravel, 10), new ItemStack(Item.emerald), new ItemStack(Item.flint.itemID, 4 + this.rand.nextInt(2), 0)));
                }

                break;
            case 1:
                addMerchantItem(var2, Item.paper.itemID, this.rand, this.func_82188_j(0.8F));
                addMerchantItem(var2, Item.book.itemID, this.rand, this.func_82188_j(0.8F));
                addMerchantItem(var2, Item.writtenBook.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Block.bookShelf.blockID, this.rand, this.func_82188_j(0.8F));
                addBlacksmithItem(var2, Block.glass.blockID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.compass.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.pocketSundial.itemID, this.rand, this.func_82188_j(0.2F));

                if (this.rand.nextFloat() < this.func_82188_j(0.07F))
                {
                    Enchantment var8 = Enchantment.field_92090_c[this.rand.nextInt(Enchantment.field_92090_c.length)];
                    int var10 = MathHelper.getRandomIntegerInRange(this.rand, var8.getMinLevel(), var8.getMaxLevel());
                    ItemStack var11 = Item.enchantedBook.func_92111_a(new EnchantmentData(var8, var10));
                    var6 = 2 + this.rand.nextInt(5 + var10 * 10) + 3 * var10;
                    var2.add(new MerchantRecipe(new ItemStack(Item.book), new ItemStack(Item.emerald, var6), var11));
                }

                break;
            case 2:
                addBlacksmithItem(var2, Item.eyeOfEnder.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Item.expBottle.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.redstone.itemID, this.rand, this.func_82188_j(0.4F));
                addBlacksmithItem(var2, Block.glowStone.blockID, this.rand, this.func_82188_j(0.3F));
                int[] var3 = new int[] {Item.swordIron.itemID, Item.swordDiamond.itemID, Item.plateIron.itemID, Item.plateDiamond.itemID, Item.axeIron.itemID, Item.axeDiamond.itemID, Item.pickaxeIron.itemID, Item.pickaxeDiamond.itemID};
                int[] var4 = var3;
                int var5 = var3.length;
                var6 = 0;

                while (true)
                {
                    if (var6 >= var5)
                    {
                        break label50;
                    }

                    int var7 = var4[var6];

                    if (this.rand.nextFloat() < this.func_82188_j(0.05F))
                    {
                        var2.add(new MerchantRecipe(new ItemStack(var7, 1, 0), new ItemStack(Item.emerald, 2 + this.rand.nextInt(3), 0), EnchantmentHelper.addRandomEnchantment(this.rand, new ItemStack(var7, 1, 0), 5 + this.rand.nextInt(15))));
                    }

                    ++var6;
                }
            case 3:
                addMerchantItem(var2, Item.coal.itemID, this.rand, this.func_82188_j(0.7F));
                addMerchantItem(var2, Item.ingotIron.itemID, this.rand, this.func_82188_j(0.5F));
                addMerchantItem(var2, Item.ingotGold.itemID, this.rand, this.func_82188_j(0.5F));
                addMerchantItem(var2, Item.diamond.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Item.swordIron.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Item.swordDiamond.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Item.axeIron.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Item.axeDiamond.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Item.pickaxeIron.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Item.pickaxeDiamond.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Item.shovelIron.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.shovelDiamond.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.hoeIron.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.hoeDiamond.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.bootsIron.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.bootsDiamond.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.helmetIron.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.helmetDiamond.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.plateIron.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.plateDiamond.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.legsIron.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.legsDiamond.itemID, this.rand, this.func_82188_j(0.2F));
                addBlacksmithItem(var2, Item.bootsChain.itemID, this.rand, this.func_82188_j(0.1F));
                addBlacksmithItem(var2, Item.helmetChain.itemID, this.rand, this.func_82188_j(0.1F));
                addBlacksmithItem(var2, Item.plateChain.itemID, this.rand, this.func_82188_j(0.1F));
                addBlacksmithItem(var2, Item.legsChain.itemID, this.rand, this.func_82188_j(0.1F));
                break;
            case 4:
                addMerchantItem(var2, Item.coal.itemID, this.rand, this.func_82188_j(0.7F));
                addMerchantItem(var2, Item.porkRaw.itemID, this.rand, this.func_82188_j(0.5F));
                addMerchantItem(var2, Item.beefRaw.itemID, this.rand, this.func_82188_j(0.5F));
                addBlacksmithItem(var2, Item.saddle.itemID, this.rand, this.func_82188_j(0.1F));
                addBlacksmithItem(var2, Item.plateLeather.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Item.bootsLeather.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Item.helmetLeather.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Item.legsLeather.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Item.porkCooked.itemID, this.rand, this.func_82188_j(0.3F));
                addBlacksmithItem(var2, Item.beefCooked.itemID, this.rand, this.func_82188_j(0.3F));
        }

        if (var2.isEmpty())
        {
            addMerchantItem(var2, Item.ingotGold.itemID, this.rand, 1.0F);
        }

        Collections.shuffle(var2);

        if (this.buyingList == null)
        {
            this.buyingList = new MerchantRecipeList();
        }

        for (int var9 = 0; var9 < par1 && var9 < var2.size(); ++var9)
        {
            this.buyingList.addToListWithCheck((MerchantRecipe)var2.get(var9));
        }
    }

    @SideOnly(Side.CLIENT)
    public void setRecipes(MerchantRecipeList par1MerchantRecipeList) {}

    public static void addMerchantItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            par0MerchantRecipeList.add(new MerchantRecipe(getRandomSizedStack(par1, par2Random), Item.emerald));
        }
    }

    private static ItemStack getRandomSizedStack(int par0, Random par1Random)
    {
        return new ItemStack(par0, getRandomCountForItem(par0, par1Random), 0);
    }

    private static int getRandomCountForItem(int par0, Random par1Random)
    {
        Tuple var2 = (Tuple)villagerStockList.get(Integer.valueOf(par0));
        return var2 == null ? 1 : (((Integer)var2.getFirst()).intValue() >= ((Integer)var2.getSecond()).intValue() ? ((Integer)var2.getFirst()).intValue() : ((Integer)var2.getFirst()).intValue() + par1Random.nextInt(((Integer)var2.getSecond()).intValue() - ((Integer)var2.getFirst()).intValue()));
    }

    public static void addBlacksmithItem(MerchantRecipeList par0MerchantRecipeList, int par1, Random par2Random, float par3)
    {
        if (par2Random.nextFloat() < par3)
        {
            int var4 = getRandomCountForBlacksmithItem(par1, par2Random);
            ItemStack var5;
            ItemStack var6;

            if (var4 < 0)
            {
                var5 = new ItemStack(Item.emerald.itemID, 1, 0);
                var6 = new ItemStack(par1, -var4, 0);
            }
            else
            {
                var5 = new ItemStack(Item.emerald.itemID, var4, 0);
                var6 = new ItemStack(par1, 1, 0);
            }

            par0MerchantRecipeList.add(new MerchantRecipe(var5, var6));
        }
    }

    private static int getRandomCountForBlacksmithItem(int par0, Random par1Random)
    {
        Tuple var2 = (Tuple)blacksmithSellingList.get(Integer.valueOf(par0));
        return var2 == null ? 1 : (((Integer)var2.getFirst()).intValue() >= ((Integer)var2.getSecond()).intValue() ? ((Integer)var2.getFirst()).intValue() : ((Integer)var2.getFirst()).intValue() + par1Random.nextInt(((Integer)var2.getSecond()).intValue() - ((Integer)var2.getFirst()).intValue()));
    }

    @SideOnly(Side.CLIENT)
    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 12)
        {
            this.generateRandomParticles("heart");
        }
        else if (par1 == 13)
        {
            this.generateRandomParticles("angryVillager");
        }
        else if (par1 == 14)
        {
            this.generateRandomParticles("happyVillager");
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    @SideOnly(Side.CLIENT)

    private void generateRandomParticles(String par1Str)
    {
        for (int var2 = 0; var2 < 5; ++var2)
        {
            double var3 = this.rand.nextGaussian() * 0.02D;
            double var5 = this.rand.nextGaussian() * 0.02D;
            double var7 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(par1Str, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 1.0D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var3, var5, var7);
        }
    }

    public void initCreature()
    {
        AkatoeVillagerRegistry.applyRandomTrade(this, worldObj.rand);
    }

    public void func_82187_q()
    {
        this.field_82190_bM = true;
    }

    public EntityAkatonian func_90012_b(EntityAgeable par1EntityAgeable)
    {
        EntityAkatonian var2 = new EntityAkatonian(this.worldObj);
        var2.initCreature();
        return var2;
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        return this.func_90012_b(par1EntityAgeable);
    }

    static
    {
        villagerStockList.put(Integer.valueOf(Item.coal.itemID), new Tuple(Integer.valueOf(16), Integer.valueOf(24)));
        villagerStockList.put(Integer.valueOf(Item.ingotIron.itemID), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        villagerStockList.put(Integer.valueOf(Item.ingotGold.itemID), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        villagerStockList.put(Integer.valueOf(Item.diamond.itemID), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        villagerStockList.put(Integer.valueOf(Item.paper.itemID), new Tuple(Integer.valueOf(24), Integer.valueOf(36)));
        villagerStockList.put(Integer.valueOf(Item.book.itemID), new Tuple(Integer.valueOf(11), Integer.valueOf(13)));
        villagerStockList.put(Integer.valueOf(Item.writtenBook.itemID), new Tuple(Integer.valueOf(1), Integer.valueOf(1)));
        villagerStockList.put(Integer.valueOf(Item.enderPearl.itemID), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        villagerStockList.put(Integer.valueOf(Item.eyeOfEnder.itemID), new Tuple(Integer.valueOf(2), Integer.valueOf(3)));
        villagerStockList.put(Integer.valueOf(Item.porkRaw.itemID), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagerStockList.put(Integer.valueOf(Item.beefRaw.itemID), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagerStockList.put(Integer.valueOf(Item.chickenRaw.itemID), new Tuple(Integer.valueOf(14), Integer.valueOf(18)));
        villagerStockList.put(Integer.valueOf(Item.fishCooked.itemID), new Tuple(Integer.valueOf(9), Integer.valueOf(13)));
        villagerStockList.put(Integer.valueOf(Item.seeds.itemID), new Tuple(Integer.valueOf(34), Integer.valueOf(48)));
        villagerStockList.put(Integer.valueOf(Item.melonSeeds.itemID), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
        villagerStockList.put(Integer.valueOf(Item.pumpkinSeeds.itemID), new Tuple(Integer.valueOf(30), Integer.valueOf(38)));
        villagerStockList.put(Integer.valueOf(Item.wheat.itemID), new Tuple(Integer.valueOf(18), Integer.valueOf(22)));
        villagerStockList.put(Integer.valueOf(Block.cloth.blockID), new Tuple(Integer.valueOf(14), Integer.valueOf(22)));
        villagerStockList.put(Integer.valueOf(Item.rottenFlesh.itemID), new Tuple(Integer.valueOf(36), Integer.valueOf(64)));
        blacksmithSellingList.put(Integer.valueOf(Item.flintAndSteel.itemID), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.shears.itemID), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.swordIron.itemID), new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
        blacksmithSellingList.put(Integer.valueOf(Item.swordDiamond.itemID), new Tuple(Integer.valueOf(12), Integer.valueOf(14)));
        blacksmithSellingList.put(Integer.valueOf(Item.axeIron.itemID), new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.axeDiamond.itemID), new Tuple(Integer.valueOf(9), Integer.valueOf(12)));
        blacksmithSellingList.put(Integer.valueOf(Item.pickaxeIron.itemID), new Tuple(Integer.valueOf(7), Integer.valueOf(9)));
        blacksmithSellingList.put(Integer.valueOf(Item.pickaxeDiamond.itemID), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        blacksmithSellingList.put(Integer.valueOf(Item.shovelIron.itemID), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        blacksmithSellingList.put(Integer.valueOf(Item.shovelDiamond.itemID), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.hoeIron.itemID), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        blacksmithSellingList.put(Integer.valueOf(Item.hoeDiamond.itemID), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.bootsIron.itemID), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        blacksmithSellingList.put(Integer.valueOf(Item.bootsDiamond.itemID), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.helmetIron.itemID), new Tuple(Integer.valueOf(4), Integer.valueOf(6)));
        blacksmithSellingList.put(Integer.valueOf(Item.helmetDiamond.itemID), new Tuple(Integer.valueOf(7), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.plateIron.itemID), new Tuple(Integer.valueOf(10), Integer.valueOf(14)));
        blacksmithSellingList.put(Integer.valueOf(Item.plateDiamond.itemID), new Tuple(Integer.valueOf(16), Integer.valueOf(19)));
        blacksmithSellingList.put(Integer.valueOf(Item.legsIron.itemID), new Tuple(Integer.valueOf(8), Integer.valueOf(10)));
        blacksmithSellingList.put(Integer.valueOf(Item.legsDiamond.itemID), new Tuple(Integer.valueOf(11), Integer.valueOf(14)));
        blacksmithSellingList.put(Integer.valueOf(Item.bootsChain.itemID), new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
        blacksmithSellingList.put(Integer.valueOf(Item.helmetChain.itemID), new Tuple(Integer.valueOf(5), Integer.valueOf(7)));
        blacksmithSellingList.put(Integer.valueOf(Item.plateChain.itemID), new Tuple(Integer.valueOf(11), Integer.valueOf(15)));
        blacksmithSellingList.put(Integer.valueOf(Item.legsChain.itemID), new Tuple(Integer.valueOf(9), Integer.valueOf(11)));
        blacksmithSellingList.put(Integer.valueOf(Item.bread.itemID), new Tuple(Integer.valueOf(-4), Integer.valueOf(-2)));
        blacksmithSellingList.put(Integer.valueOf(Item.melon.itemID), new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
        blacksmithSellingList.put(Integer.valueOf(Item.appleRed.itemID), new Tuple(Integer.valueOf(-8), Integer.valueOf(-4)));
        blacksmithSellingList.put(Integer.valueOf(Item.cookie.itemID), new Tuple(Integer.valueOf(-10), Integer.valueOf(-7)));
        blacksmithSellingList.put(Integer.valueOf(Block.glass.blockID), new Tuple(Integer.valueOf(-5), Integer.valueOf(-3)));
        blacksmithSellingList.put(Integer.valueOf(Block.bookShelf.blockID), new Tuple(Integer.valueOf(3), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.plateLeather.itemID), new Tuple(Integer.valueOf(4), Integer.valueOf(5)));
        blacksmithSellingList.put(Integer.valueOf(Item.bootsLeather.itemID), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.helmetLeather.itemID), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.legsLeather.itemID), new Tuple(Integer.valueOf(2), Integer.valueOf(4)));
        blacksmithSellingList.put(Integer.valueOf(Item.saddle.itemID), new Tuple(Integer.valueOf(6), Integer.valueOf(8)));
        blacksmithSellingList.put(Integer.valueOf(Item.expBottle.itemID), new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
        blacksmithSellingList.put(Integer.valueOf(Item.redstone.itemID), new Tuple(Integer.valueOf(-4), Integer.valueOf(-1)));
        blacksmithSellingList.put(Integer.valueOf(Item.compass.itemID), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        blacksmithSellingList.put(Integer.valueOf(Item.pocketSundial.itemID), new Tuple(Integer.valueOf(10), Integer.valueOf(12)));
        blacksmithSellingList.put(Integer.valueOf(Block.glowStone.blockID), new Tuple(Integer.valueOf(-3), Integer.valueOf(-1)));
        blacksmithSellingList.put(Integer.valueOf(Item.porkCooked.itemID), new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
        blacksmithSellingList.put(Integer.valueOf(Item.beefCooked.itemID), new Tuple(Integer.valueOf(-7), Integer.valueOf(-5)));
        blacksmithSellingList.put(Integer.valueOf(Item.chickenCooked.itemID), new Tuple(Integer.valueOf(-8), Integer.valueOf(-6)));
        blacksmithSellingList.put(Integer.valueOf(Item.eyeOfEnder.itemID), new Tuple(Integer.valueOf(7), Integer.valueOf(11)));
        blacksmithSellingList.put(Integer.valueOf(Item.arrow.itemID), new Tuple(Integer.valueOf(-12), Integer.valueOf(-8)));
    }

	@Override
	public void func_110297_a_(ItemStack itemstack) {
		// TODO Auto-generated method stub
		
	}
}
/**/