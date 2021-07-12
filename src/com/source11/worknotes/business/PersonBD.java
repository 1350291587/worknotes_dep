package com.source11.worknotes.business;

import com.source11.worknotes.dao.DaoFactory;
import com.source11.worknotes.dao.PersonDao;
import com.source11.worknotes.domain.Person;

import java.util.List;
import java.util.Iterator;

/**
 * ���Person��ҵ������ࡣ
 * ��Ҫ�����ǣ�
 * 1. ����ҵ���߼��Ĵ���
 * 2. �Գ־ò��ȡ�����ݽ������ݹ��ˡ�
 */
public class PersonBD {

    private static short STATUS_NORMAL=0;
    /**
     * ���һ��PersonDao��ʵ���壬��������DAO����ʡ�
     */
    private static PersonDao persondao=DaoFactory.createPersonDao();

    /**
     * ������ݿ������е���Ա������
     * @return ȫ����Ա��Ϣ�б�
     */
    public static List getAllPerson(){
        return persondao.getListAll();
    }

    /**
     * ������ݿ������й���״̬��������Ա����
     * @return ����Ҫ�����Ա�б�
     */
    public static List getNormalPersonList(){
        List list = persondao.getListAll();

        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            if (((Person)iterator.next()).getWorkStatusID() != STATUS_NORMAL){
                iterator.remove();
            }
        }

        return list;

    }

    /**
     * ����ָ����¼��ˮ�ţ���ö�Ӧ����Ա������
     * @param personid ��¼��ˮ�š�
     * @return  ָ���ĸ�����Ϣ
     */
    public static Person getDetalByPID(int personid){
        return persondao.getDetail(personid);
    }

    /**
     * ������Ա������
     * ���µĹؼ�������personid
     * @param person �����µĸ�����Ϣ��
     */
    public static void updatePerson(Person person){
        persondao.update(person);
    }

    /**
     * ����ָ������Ա������
     * �����ظ�����Ա��Ϣ��
     * @param person  �µĸ�����Ϣ��
     */
    public static void createPerson(Person person){
        persondao.create(person);
    }

}
