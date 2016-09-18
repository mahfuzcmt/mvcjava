/*
------------------------------------------------------------------------------
M E T A   D A T A
------------------------------------------------------------------------------
*/

--  MetaProperty
Insert into MetaProperty (OID, valueJSON,description) values ('MenuJSON','{
  "{
  "children": [
    {
      "id": "webMenu",
      "url": "webMenu",
      "text": "Web Menu",
      "enable": false,
      "children": [
        {
          "id": "dashboard",
          "url": "dashboard",
          "text": "dashboard",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "student",
          "url": "student",
          "text": "Student",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "teacher",
          "url": "teacher",
          "text": "Teacher",
          "enable": true,
          "settings": [],
          "children": [{
              "id": "schedule",
              "url": "schedule",
              "text": "Schedule",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ]},
            {
              "id": "mystudents",
              "url": "mystudents",
              "text": "My Student",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ]}]
        },
        {
          "id": "course",
          "url": "course",
          "text": "Course",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "registration",
          "url": "registration",
          "text": "Registration",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "settings",
          "url": "settings",
          "text": "Settings",
          "enable": true,
          "settings": [],
          "children": [
            {
              "id": "userManagement",
              "url": "userManagement",
              "text": "User Management",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ],
              "$$hashKey": "object:569"
            },
            {
              "id": "roleManagement",
              "url": "roleManagement",
              "text": "Role Management",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ],
              "$$hashKey": "object:570"
            }
          ]
        }
      ]
    }
  ]
}','Menu JSON Template');
commit;


--- Role
insert into Role (roleID, roleDescription, featureJSON) values('teacher','Course Teacher',

'{
  "children": [
    {
      "id": "webMenu",
      "url": "webMenu",
      "text": "Web Menu",
      "enable": false,
      "children": [
        {
          "id": "dashboard",
          "url": "dashboard",
          "text": "dashboard",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "student",
          "url": "student",
          "text": "Student",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "teacher",
          "url": "teacher",
          "text": "Teacher",
          "enable": true,
          "settings": [],
          "children": [{
              "id": "schedule",
              "url": "schedule",
              "text": "Schedule",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ]},
            {
              "id": "mystudents",
              "url": "mystudents",
              "text": "My Student",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ]}]
        },
        {
          "id": "course",
          "url": "course",
          "text": "Course",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "registration",
          "url": "registration",
          "text": "Registration",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "settings",
          "url": "settings",
          "text": "Settings",
          "enable": true,
          "settings": [],
          "children": [
            {
              "id": "userManagement",
              "url": "userManagement",
              "text": "User Management",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ],
              "$$hashKey": "object:569"
            },
            {
              "id": "roleManagement",
              "url": "roleManagement",
              "text": "Role Management",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ],
              "$$hashKey": "object:570"
            }
          ]
        }
      ]
    }
  ]
}');
insert into Role (roleID, roleDescription, featureJSON) values('admin','Super Admin',

'{
  "children": [
    {
      "id": "webMenu",
      "url": "webMenu",
      "text": "Web Menu",
      "enable": false,
      "children": [
        {
          "id": "dashboard",
          "url": "dashboard",
          "text": "dashboard",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "student",
          "url": "student",
          "text": "Student",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "teacher",
          "url": "teacher",
          "text": "Teacher",
          "enable": true,
          "settings": [],
          "children": [{
              "id": "schedule",
              "url": "schedule",
              "text": "Schedule",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ]},
            {
              "id": "mystudents",
              "url": "mystudents",
              "text": "My Student",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ]}]
        },
        {
          "id": "course",
          "url": "course",
          "text": "Course",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "registration",
          "url": "registration",
          "text": "Registration",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "settings",
          "url": "settings",
          "text": "Settings",
          "enable": true,
          "settings": [],
          "children": [
            {
              "id": "userManagement",
              "url": "userManagement",
              "text": "User Management",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ],
              "$$hashKey": "object:569"
            },
            {
              "id": "roleManagement",
              "url": "roleManagement",
              "text": "Role Management",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ],
              "$$hashKey": "object:570"
            }
          ]
        }
      ]
    }
  ]
}');
commit;


--- Login

insert into Login (loginID, roleID, featureJSON, password, status, name, phoneNo, email) values('admin','admin',
'
{
  "children": [
    {
      "id": "webMenu",
      "url": "webMenu",
      "text": "Web Menu",
      "enable": false,
      "children": [
        {
          "id": "dashboard",
          "url": "dashboard",
          "text": "dashboard",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "student",
          "url": "student",
          "text": "Student",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "teacher",
          "url": "teacher",
          "text": "Teacher",
          "enable": true,
          "settings": [],
          "children": [{
              "id": "schedule",
              "url": "schedule",
              "text": "Schedule",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ]},
            {
              "id": "mystudents",
              "url": "mystudents",
              "text": "My Student",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ]}]
        },
        {
          "id": "course",
          "url": "course",
          "text": "Course",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "registration",
          "url": "registration",
          "text": "Registration",
          "enable": true,
          "settings": [],
          "children": []
        },
        {
          "id": "settings",
          "url": "settings",
          "text": "Settings",
          "enable": true,
          "settings": [],
          "children": [
            {
              "id": "userManagement",
              "url": "userManagement",
              "text": "User Management",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ],
              "$$hashKey": "object:569"
            },
            {
              "id": "roleManagement",
              "url": "roleManagement",
              "text": "Role Management",
              "enable": true,
              "isSubmenu": true,
              "children": [],
              "settings": [
                {
                  "id": "itemperpage",
                  "enable": true,
                  "value": "15",
                  "children": []
                },
                {
                  "id": "defaultview",
                  "enable": true,
                  "value": "card",
                  "children": []
                }
              ],
              "$$hashKey": "object:570"
            }
          ]
        }
      ]
    }
  ]
}','RReQzFI520Y=','A','Mahfuz Ahmed','+8801975585960','mahfuzcmt@gmail.com');
commit;
