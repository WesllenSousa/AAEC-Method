package entidades.appliances;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AppliancesBean.class)
public abstract class AppliancesBean_ {

	public static volatile SingularAttribute<AppliancesBean, String> name;
	public static volatile SingularAttribute<AppliancesBean, Float> consumptionOn;
	public static volatile SingularAttribute<AppliancesBean, String> model;
	public static volatile SingularAttribute<AppliancesBean, Integer> id;
	public static volatile SingularAttribute<AppliancesBean, Float> consumptionStandby;
	public static volatile SingularAttribute<AppliancesBean, Integer> priority;
	public static volatile SingularAttribute<AppliancesBean, EnumLigarDesligar> status;
	public static volatile SingularAttribute<AppliancesBean, EnumTypeAppliance> typeAppliance;
	public static volatile SingularAttribute<AppliancesBean, Integer> tempoTipo2;

}

