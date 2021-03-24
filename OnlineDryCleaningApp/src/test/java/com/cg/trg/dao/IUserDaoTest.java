//@DataJpaTest
//class IUserRepositoryIntegrationTest {
//    @Autowired
//    private TestEntityManager entityManager;
//
//    @Autowired
//    private IUserRepository iUserRepository;
//
// @Test
//    public void whenFindByEmailId_thenReturnUser() {
//        User user= new User("Spring Dao Integration Test","test-content");
//        entityManager.persistAndFlush(user);
//
//        List<User> foundList = iUserRepository.findByEmailId(user.getEmailId());
//        if(foundList.size()!=0) {
//        	assertThat(foundList.get(0).getEmailId()).isEqualTo(user.getEmailId());
//        }else {
//        	assertThat(foundList.get(0).getEmailId()).isNotEqualTo(user.getEmailId());
//        }
//    }
//
//@Test
//    public void whenInvalidEmailId_thenReturnNull() {
//    	List<User> foundList = iUserRepository.findByEmailId("Unknown EmailId");
//        assertThat(foundList).isEmpty();
//    }
//
// @Test
//    public void whenFindByEmailId_thenReturnUser() {
//    	User user= new User("Spring Test","test-content");
//        entityManager.persistAndFlush(user);
//
//        User fromDb = iUserRepository.findByEmailId(user.getId())
//        										.orElse(null);
//        assertThat(fromDb.getTitle()).isEqualTo(user.getTitle());
//    }
//
//@Test
//    public void whenInvalidEmailId_thenReturnNull() {
//    	User fromDb = noteRepository.findByEmailId(-11l).orElse(null);
//        assertThat(fromDb).isNull();
//    }
//
//@Test
//    public void givenSetOfUser_whenFindAll_thenReturnAllUser() {
//    	User user1= new User("Spring Controller Layer Test","test");
//    	User user2= new User("Spring Dao Layer Test","test");
//    	User user3= new User("Spring Service Layer Test","test");
//       
//        entityManager.persist(user1);
//        entityManager.persist(user2);
//        entityManager.persist(user3);
//        entityManager.flush();
//
//List<User> allUser = iUserRepository.findAll();
//assertThat(allNotes).hasSize(--);
//}
//
//
//
//
// @Test
//    public void whenFindEmailId_thenReturnUser() {
//        User user= new User("Spring Dao Integration Test","test-content");
//        entityManager.persistAndFlush(user);
//
//        List<User> foundList = iUserRepository.findEmailId(user.getEmailId());
//        if(foundList.size()!=0) {
//        	assertThat(foundList.get(0).getEmailId()).isEqualTo(user.getEmailId());
//        }else {
//        	assertThat(foundList.get(0).getEmailId()).isNotEqualTo(user.getEmailId());
//        }
//    }
//
//@Test
//    public void whenInvalidEmailId_thenReturnNull() {
//    	List<User> foundList = iUserRepository.findEmailId("Unknown EmailId");
//        assertThat(foundList).isEmpty();
//    }
//
// @Test
//    public void whenFindEmailId_thenReturnUser() {
//    	User user= new User("Spring Test","test-content");
//        entityManager.persistAndFlush(user);
//
//        User fromDb = iUserRepository.findEmailId(user.getId())
//        										.orElse(null);
//        assertThat(fromDb.getTitle()).isEqualTo(user.getTitle());
//    }
//
//@Test
//    public void whenInvalidEmailId_thenReturnNull() {
//    	User fromDb = noteRepository.findEmailId(-11l).orElse(null);
//        assertThat(fromDb).isNull();
//    }
//
//@Test
//    public void givenSetOfUser_whenFindAll_thenReturnAllUser() {
//    	User user1= new User("Spring Controller Layer Test","test");
//    	User user2= new User("Spring Dao Layer Test","test");
//    	User user3= new User("Spring Service Layer Test","test");
//       
//        entityManager.persist(user1);
//        entityManager.persist(user2);
//        entityManager.persist(user3);
//        entityManager.flush();
//
//User allUser = iUserRepository.findAll();
//assertThat(allNotes).hasSize(--);
//}
//}