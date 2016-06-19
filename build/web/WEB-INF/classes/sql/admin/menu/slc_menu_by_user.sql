/* 
 * Coppyright: luckybear
 */
/**
 * Author:  Lucky Bear
 * Created: Jun 19, 2016
 */
select a.* 
from po_menu a 
left join group_users_page b on b.page_id = a.page_id 
left join users c on c.group_id = b.group_id 
where c.user_id = ? 
or (c.user_id is null and a.page_bean is null)

